package com.xiaozheng.common.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiao
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket buildDocket(){

        // 添加 head 参数配置 start
        ParameterBuilder token = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        token.name("Authorization").description("token 信息").modelRef(new ModelRef("String")).parameterType("header").required(false).build();
        pars.add(token.build());

        List<ApiKey> apiKeys = Lists.newArrayList();
        apiKeys.add(new ApiKey("app-token", "app-token", "header"));

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                // 注意一下 globalOperationParameters 这行配置
                .globalOperationParameters(pars)
                // 全局Token
                .securitySchemes(apiKeys);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("更多请咨询服务开发者XiaoZheng.")
                .contact(new Contact("XiaoZheng", "https://smallblog.cn/", "1911298402@qq.com"))
                .version("1.0")
                .build();
    }

}