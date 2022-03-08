package com.xiaozheng.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.config
 * @ClassName: WebConfig
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2020/12/23 12:10
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 配置跨源请求处理。
     *
     * @param registry
     * @since 4.2
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.允许所有请求路径
         * 2.跨域请求来源
         * 3.方法
         * 4.是否运行携带参数
         * 5.响应时间
         */
        registry.addMapping("/**")
                .allowedOrigins("*", "null")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}