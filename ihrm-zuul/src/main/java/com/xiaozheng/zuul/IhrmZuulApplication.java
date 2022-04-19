package com.xiaozheng.zuul;

import com.xiaozheng.common.config.DruidConfig;
import com.xiaozheng.common.config.MybatisPlusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-11 10:47:03
 */
@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@EnableZuulProxy
//排除 MybatisPlusConfig.java配置类
@ComponentScan(excludeFilters= {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value= {MybatisPlusConfig.class, DruidConfig.class})})
@EnableEurekaClient
@EnableDiscoveryClient
public class IhrmZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmZuulApplication.class, args);
    }

}
