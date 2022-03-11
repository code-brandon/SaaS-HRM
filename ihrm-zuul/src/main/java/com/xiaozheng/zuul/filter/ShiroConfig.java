package com.xiaozheng.zuul.filter;

import com.xiaozheng.common.shiro.StatelessAuthcFilter;
import com.xiaozheng.common.shiro.realm.IhrmRealm;
import com.xiaozheng.common.shiro.session.CustomSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Xiao
 */
@Configuration
public class ShiroConfig {

    @Bean
    public IhrmRealm getRealm() {
        return new IhrmRealm();
    }


    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;


    @Bean
    RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setPassword(password);
        return redisManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 会话管理
     * @return
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        CustomSessionManager sessionManager = new CustomSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        // 禁用cookie
        sessionManager.setSessionIdCookieEnabled(false);
        // 禁用Url重写
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     *
     * @param realm
     * @return
     */
    @Bean
    public WebSecurityManager getSecurityManager(IhrmRealm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        defaultWebSecurityManager.setSessionManager(sessionManager());
        defaultWebSecurityManager.setCacheManager(redisCacheManager());
        return defaultWebSecurityManager;
    }

    /**
     * 缓存
     * @return
     */
    @Bean("shiroRedis")
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(WebSecurityManager webSecurityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(webSecurityManager);
        // 跳转的url,登录页
        filterFactoryBean.setLoginUrl("/autherror?code=1");
        // 未授权的url
        filterFactoryBean.setUnauthorizedUrl("/autherror?code=2");

        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("user", new StatelessAuthcFilter());
        filterFactoryBean.setFilters(filters);

        // 设置过滤器集合
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        // 匿名访问
        linkedHashMap.put("/api/system/pe/user/login", "anon");
        linkedHashMap.put("/**/autherror", "anon");
        linkedHashMap.put("/**/swagger-ui.html", "anon");
        linkedHashMap.put("/**/swagger-ui.html/**", "anon");
        linkedHashMap.put("/**/swagger-resources/**", "anon");
        linkedHashMap.put("/**/webjars/**", "anon");
        linkedHashMap.put("/**/v2/api-docs", "anon");
        // 认证之后 可以访问
        // linkedHashMap.put("/**", "authc");
        // 所有请求需要认证
        linkedHashMap.put("/**", "user");
        filterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return filterFactoryBean;
    }

    /**
     * 开启对shior注解的支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(WebSecurityManager webSecurityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(webSecurityManager);
        return advisor;
    }

}