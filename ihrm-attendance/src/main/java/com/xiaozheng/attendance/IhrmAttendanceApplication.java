package com.xiaozheng.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.xiaozheng"})
@EnableEurekaClient
@EnableDiscoveryClient
public class IhrmAttendanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmAttendanceApplication.class, args);
    }

}
