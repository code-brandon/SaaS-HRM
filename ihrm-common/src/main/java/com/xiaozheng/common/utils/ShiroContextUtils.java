package com.xiaozheng.common.utils;

import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import com.xiaozheng.common.entity.PeUserDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.common.config
 * @ClassName: ShiroContextUtils
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/9 23:25
 */
@Slf4j
public class ShiroContextUtils {

    /**
     * 从Shiro中获取用户信息
     * @return
     */
    public static PeUserDto getProfile() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        PeUserDto peUserDto = (PeUserDto) principals.getPrimaryPrincipal();
        log.info("从Shiro中获取用户信息 : {}" , peUserDto.getUsername());
        return peUserDto;
    }

    /**
     * 自定义加密
     * @return
     */
    public static String customEncryption(String password,String salt) {
        return new Md5Hash(EncryptUtils.md5Base64(password), salt, 6).toString();
    }
}
