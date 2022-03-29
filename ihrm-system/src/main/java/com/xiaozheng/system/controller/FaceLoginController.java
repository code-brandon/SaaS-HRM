package com.xiaozheng.system.controller;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.model.dto.FaceLogin;
import com.xiaozheng.model.dto.QRCode;
import com.xiaozheng.system.service.impl.FaceLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping("/sys/faceLogin")
public class FaceLoginController {

    @Autowired
    private FaceLoginServiceImpl faceLoginService;

    /**
     * 获取刷脸登录二维码
     */
    @GetMapping(value = "/qrcode")
    public R<QRCode> qrcode() throws Exception {
        QRCode qrCode = faceLoginService.getQRCode();
        return Objects.nonNull(qrCode) ? R.ok("二维码制作成功").data(qrCode) : R.error(ResultCode.FAIL.code(),"二维码制作失败");
    }

    /**
     * 检查二维码：登录页面轮询调用此方法，根据唯一标识code判断用户登录情况
     */
    @GetMapping(value = "/qrcode/{code}")
    public R<FaceLogin> qrcodeCeck(@PathVariable(name = "code") String code) throws Exception {
        FaceLogin faceLogin = faceLoginService.checkQRCode(code);
        return Objects.nonNull(faceLogin) ? R.ok("查询成功").data(faceLogin) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 人脸登录：根据落地页随机拍摄的面部头像进行登录
     *          根据拍摄的图片调用百度云AI进行检索查找
     */
    @PostMapping(value = "/{code}")
    public R<Boolean> loginByFace(@PathVariable(name = "code") String code, @RequestParam(name = "file") MultipartFile attachment) throws Exception {
        //人脸登录获取用户id（不为null登录成功）
        String userId = faceLoginService.loginByFace(code, attachment);
        return !StringUtils.isEmpty(userId) ? R.ok("登录成功").data(true) : R.error(ResultCode.FAIL.code(),"登录失败").data(false);
    }


    /**
     * 图像检测，判断图片中是否存在面部头像
     */
    @PostMapping(value = "/checkFace")
    public R<Boolean> checkFace(@RequestParam(name = "file") MultipartFile attachment) throws Exception {
        boolean aBoolean = faceLoginService.checkFace(attachment);
        return aBoolean ? R.ok("查询成功").data(aBoolean) : R.error(ResultCode.FAIL.code(),"查询失败").data(aBoolean);
    }

}