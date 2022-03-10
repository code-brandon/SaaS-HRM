package com.xiaozheng.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 开启EurekaServer服务端
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 16:48:36
 */
@EnableEurekaServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class IhrmEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmEurekaApplication.class, args);
    }

}
