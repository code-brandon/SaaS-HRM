package com.xiaozheng.system.shiro.realm;

import com.xiaozheng.common.shiro.realm.IhrmRealm;
import com.xiaozheng.common.entity.PeUserDto;
import com.xiaozheng.system.service.PeUserService;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.system.shiro.realm
 * @ClassName: UserRealm
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/8 23:39
 */
public class UserRealm extends IhrmRealm {

    @Autowired
    private PeUserService peUserService;

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取用户的手机号和密码
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) authenticationToken;
        String username = passwordToken.getUsername();
        String password = String.valueOf(passwordToken.getPassword());
        //2.根据手机号查询用户
        PeUserDto peUserDto = peUserService.profileByMobile(username);
        //3.判断用户是否存在，用户密码是否和输入密码一致
        if (Objects.isNull(peUserDto) || !peUserDto.getPassword().equals(password)) {
            // 返回null，会抛出异常，标识用户名和密码不匹配
            return null;
        }
        //4.构造安全数据并返回（基本数据，权限信息) , 构造方法:安全数据，密码, realm域名
        return new SimpleAuthenticationInfo(peUserDto, password, getName());
    }
}
