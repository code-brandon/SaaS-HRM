package com.xiaozheng.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.xiaozheng.model.dto.FaceLogin;
import com.xiaozheng.model.dto.QRCode;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.system.dao.PeUserDao;
import com.xiaozheng.system.utils.BaiduAiUtil;
import com.xiaozheng.system.utils.QRCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Service
public class FaceLoginServiceImpl {

    @Value("${qr.url}")
    private String url;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private BaiduAiUtil baiduAiUtil;

    @Autowired
    private PeUserDao peUserDao;

    //创建二维码
    public QRCode getQRCode() throws Exception {
        // 创建唯一标识
        String idStr = IdWorker.getIdStr();
        // 生成二维码
        String URL = url + "?code=" + idStr;
        String qrCodeFile = QRCodeUtil.crateQRCode(URL);
        // 存入当前二维码状态（redis）
        redisTemplate.boundValueOps(getCacheKey(idStr)).set(new FaceLogin("-1"), 15, TimeUnit.MINUTES);
        // 返回二维码
        return new QRCode(idStr, qrCodeFile);
    }

    //根据唯一标识，查询用户是否登录成功
    public FaceLogin checkQRCode(String code) {
        String cacheKey = getCacheKey(code);
        return (FaceLogin) redisTemplate.opsForValue().get(cacheKey);
    }

    //扫描二维码之后，使用拍摄照片进行登录
    public String loginByFace(String code, MultipartFile attachment) throws Exception {
        String userId = baiduAiUtil.faceSearch(Base64Utils.encodeToString(attachment.getBytes()));
        FaceLogin faceLogin = new FaceLogin("0");
        if (!StringUtils.isEmpty(userId)) {
            try {
                PeUserEntity peUserEntity = peUserDao.selectById(userId);
                //1.构造登录令牌UsernamePasswordToken
                UsernamePasswordToken passwordToken = new UsernamePasswordToken(peUserEntity.getMobile(), peUserEntity.getPassword());
                //2.获取subject
                Subject subject = SecurityUtils.getSubject();
                //3.调用login方法，进入realm完成认证//4.获取sessionId
                subject.login(passwordToken);
                //5.构造返回结果
                String token = (String) subject.getSession().getId();
                faceLogin = new FaceLogin("1", token, userId);
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
        //6.修改二维码的状态
        redisTemplate.boundValueOps(getCacheKey(code)).set(faceLogin,15,TimeUnit.MINUTES);
        return userId;
    }

    //构造缓存key
    private String getCacheKey(String code) {
        return "qrcode_" + code;
    }

    /**
     * 检测人脸，查看图片是否有人脸
     * @param attachment
     * @return
     * @throws IOException
     */
    public boolean checkFace(MultipartFile attachment) throws IOException {
        return baiduAiUtil.faceCheck(Base64.getEncoder().encodeToString(attachment.getBytes()));
    }
}