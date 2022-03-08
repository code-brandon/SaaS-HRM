package com.xiaozheng.company;

import com.xiaozheng.common.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @author 小政同学    QQ:xiaozheng666888@qq.com
 * @ClassName CompanyApplication
 * @CreateTime 2021/12/23 下午11:05
 */
@SpringBootApplication(scanBasePackages = "com.xiaozheng")
@MapperScan("com.xiaozheng.company.dao")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
