package com.xiaozheng.audit;

import com.xiaozheng.common.config.DruidConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 排除 SecurityAutoConfiguration，因为activiti 7.x 以上 默认使用Security，而本项目使用的是Shiro
 */
@SpringBootApplication(scanBasePackages = "com.xiaozheng",exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
})
@MapperScan("com.xiaozheng.audit.dao")
// 排除自定义的DruidConfig
@ComponentScan(excludeFilters= {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value= { DruidConfig.class})})
@EnableEurekaClient
@EnableDiscoveryClient()
@EnableFeignClients()
public class IhrmAuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmAuditApplication.class, args);
    }

}
