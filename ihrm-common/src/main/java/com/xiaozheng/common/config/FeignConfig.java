package com.xiaozheng.common.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Objects;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.common.config
 * @ClassName: FeignConfig
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/10 18:20
 */
@Configuration
public class FeignConfig {
    /**
     * 配置feign拦截器,解决请求头问题
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor() {

        return new RequestInterceptor() {
            /**
             * 获取所有浏览器发送的请求属性，请求头赋值到feign
             *
             * @param requestTemplate
             */
            @Override
            public void apply(RequestTemplate requestTemplate) {
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                if (Objects.nonNull(requestAttributes)) {
                    HttpServletRequest request = requestAttributes.getRequest();
                    Enumeration<String> headerNames = request.getHeaderNames( ) ;
                    if ( Objects.nonNull(headerNames) ) {
                        while (headerNames.hasMoreElements()) {
                            // 请求头名称
                            String name = headerNames.nextElement();
                            // 请求头数据
                            String value = request.getHeader(name);
                            requestTemplate.header(name, value);
                        }
                    }
                }
            }
        };
    }

}