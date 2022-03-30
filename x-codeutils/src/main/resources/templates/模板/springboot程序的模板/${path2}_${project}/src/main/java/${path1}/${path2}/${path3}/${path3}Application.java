package ${pPackage};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

//1.配置springboot的包扫描
@SpringBootApplication(scanBasePackages = "${path1}.${path2}")
//2.配置jpa注解的扫描
@EntityScan(value="${path1}.${path2}.${path3}.pojo")
//3.注册到eureka
@EnableEurekaClient
public class ${path3}Application {

    /**
     * 启动方法
     */
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }
}
