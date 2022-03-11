package com.xiaozheng.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-11 10:47:03
 */
@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class IhrmZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmZuulApplication.class, args);
    }

}
