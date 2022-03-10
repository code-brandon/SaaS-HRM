package com.xiaozheng.employee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@MapperScan("com.xiaozheng.employee.dao")
public class IhrmEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmEmployeeApplication.class, args);
    }

}
