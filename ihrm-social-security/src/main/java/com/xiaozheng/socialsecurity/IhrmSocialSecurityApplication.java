package com.xiaozheng.socialsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.xiaozheng"})
@EnableEurekaClient
@EnableDiscoveryClient
public class IhrmSocialSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmSocialSecurityApplication.class, args);
    }

}
