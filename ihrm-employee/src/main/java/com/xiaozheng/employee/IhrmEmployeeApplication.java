package com.xiaozheng.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@MapperScan("com.xiaozheng.employee.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class IhrmEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmEmployeeApplication.class, args);
    }

}
