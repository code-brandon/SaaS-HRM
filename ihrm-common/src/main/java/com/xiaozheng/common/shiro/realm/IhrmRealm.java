package com.xiaozheng.common.shiro.realm;

import com.google.common.collect.Sets;
import com.xiaozheng.common.entity.PeUserDto;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

//公共的realm：获取安全数据，构造权限信息
public class IhrmRealm  extends AuthorizingRealm {

    public void setName(String name) {
        super.setName("ihrmRealm");
    }

    //授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        HashSet<String> hashSet = Sets.newHashSet();

        //1.获取安全数据
        PeUserDto peUserDto = (PeUserDto) principalCollection.getPrimaryPrincipal();

        //2.获取权限信息
        Map<String, Object> roles = peUserDto.getRoles();
        if (Objects.nonNull(roles)) {
            hashSet.addAll((new HashSet<String>( (List<String>)roles.get("apis"))));
        }
        //3.构造权限数据，返回值
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(hashSet);
        return info;
    }

    //认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
