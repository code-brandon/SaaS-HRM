package com.xiaozheng.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@MapperScan("com.xiaozheng.system.dao")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients()
public class IhrmSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmSystemApplication.class, args);
    }

}
