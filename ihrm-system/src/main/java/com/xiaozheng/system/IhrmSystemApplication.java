package com.xiaozheng.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@MapperScan("com.xiaozheng.system.dao")
public class IhrmSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmSystemApplication.class, args);
    }

}
