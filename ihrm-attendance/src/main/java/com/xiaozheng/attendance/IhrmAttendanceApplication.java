package com.xiaozheng.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.xiaozheng"})
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients()
public class IhrmAttendanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmAttendanceApplication.class, args);
    }

}
