package com.xiaozheng.system.service.pe.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.JwtUtils;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.dto.PeUserDto;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import com.xiaozheng.system.dao.pe.PeUserDao;
import com.xiaozheng.system.service.pe.PePermissionService;
import com.xiaozheng.system.service.pe.PeUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("peUserService")
public class PeUserServiceImpl extends ServiceImpl<PeUserDao, PeUserEntity> implements PeUserService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PePermissionService pePermissionService;

    @Override
    public PageUtils<PeUserEntity> queryPage(PeUserEntity peUser, Map<String, Object> params) {
        IPage<PeUserEntity> page = this.page(
                new Query<PeUserEntity>().getPage(params),
                Wrappers.query(peUser)
        );
        return new PageUtils(page);
    }

    /**
     * 通过主键查询单条数据和所关联角色
     *
     * @param id
     * @return
     */
    @Override
    public PeUserEntity infoAndRoleById(String id) {
        return baseMapper.infoAndRoleById(id);
    }

    /**
     * 通过手机号查询用户详情
     *
     * @param mobile
     * @return
     */
    @Override
    public PeUserDto profileByMobile(String mobile) {
        PeUserDto peUserDto = new PeUserDto();
        PeUserEntity peUserEntity = baseMapper.selectOne(new QueryWrapper<PeUserEntity>().eq("mobile", mobile));
        BeanUtils.copyProperties(peUserEntity, peUserDto);

        // 获取权限
        Map<String, Object> permMap = pePermissionService.queryByUserIdOrEnVisible(peUserEntity.getId(),peUserEntity.getLevel());
        peUserDto.setRoles(permMap);

        return peUserDto;
    }

    /**
     * 根据Mobile 查询用户
     * @param mobile
     * @return
     */
    @Override
    public PeUserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<PeUserEntity>().eq("mobile", mobile));
    }

    /**
     * 用户登录
     * @param usetVo
     * @return
     */
    @Override
    public String login(PeUsetVo usetVo) {
        String id = null;

        try {
            //1.构造登录令牌UsernamePasswordToken
            String md5hashPass = new Md5Hash(EncryptUtils.md5Base64(usetVo.getPassword()), usetVo.getMobile(), 6).toString();
            UsernamePasswordToken passwordToken = new UsernamePasswordToken(usetVo.getMobile(),md5hashPass);
            //2.获取subject
            Subject subject = SecurityUtils.getSubject();
            //3.调用login方法，进入realm完成认证//4.获取sessionId
            subject.login(passwordToken);
            //5.构造返回结果
            id = (String) subject.getSession().getId();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        /*// PeUserEntity peUserEntity = this.queryByMobile(usetVo.getMobile());
        if (Objects.isNull(peUserEntity) || !peUserEntity.getPassword().equals(usetVo.getPassword())) {
            // 登录失败
            return null;
        }
        // 登录成功
        Map<String, Object> map = Maps.newHashMap();
        map.put("companyId", peUserEntity.getCompanyId());
        map.put("companyName", peUserEntity.getCompanyName());
        return jwtUtils.createJwt(peUserEntity.getId(), peUserEntity.getUsername(), map);*/

        return id;
    }

    /**
     * 获取个人信息
     *
     * @param userId
     * @return
     */
    @Override
    public PeUserDto profile(String userId) {
        PeUserDto peUserDto = new PeUserDto();
        PeUserEntity peUserEntity = baseMapper.selectById(userId);
        BeanUtils.copyProperties(peUserEntity, peUserDto);

        // 获取权限
        Map<String, Object> permMap = pePermissionService.queryByUserIdOrEnVisible(peUserEntity.getId(),peUserEntity.getLevel());
        peUserDto.setRoles(permMap);

        return peUserDto;
    }

    /**
     * 保存用户数据
     *
     * @param peUser 实体对象
     * @return 新增结果
     */
    @Override
    public boolean saveAndEncrypt(PeUserEntity peUser) {
        String md5hashPass = new Md5Hash(EncryptUtils.md5Base64(peUser.getPassword()), peUser.getMobile(), 6).toString();
        peUser.setPassword(md5hashPass);
        peUser.setLevel("user");
        return baseMapper.insert(peUser) > 0;
    }

}