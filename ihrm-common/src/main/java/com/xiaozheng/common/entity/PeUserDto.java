package com.xiaozheng.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Map;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.dto
 * @ClassName: PeUserDto
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/2/13 17:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeUserDto extends PeUsetVo implements Serializable , AuthCachePrincipal {

    /**
     * 角色
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Map<String, Object> roles;

    /**
     * AuthCacheKey used to store authorization cache. The authorization cache key in Redis format is {cacheManagePrefix} + {realmName} + ":" + {authCacheKey}.
     * For example:
     * cacheManagePrefix = shiro:mycache:
     * realmName = exampleRealm.authorizationCache
     * authCacheKey = 123
     * authorization redis key = shiro:mycache:exampleRealm.authorizationCache:123
     * <p>
     * In most cases, authCacheKey should be userId or userName
     *
     * @return
     */
    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
