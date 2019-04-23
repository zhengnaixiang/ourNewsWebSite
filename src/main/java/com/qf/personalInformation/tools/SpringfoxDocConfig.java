package com.qf.personalInformation.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 * 1.文档开关
 * 2.接口文档标题
 * 3.controller位置
 *
 */

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "com.qf.personalInformation.controller" })
public class SpringfoxDocConfig {

    //@Value("${test}")
    boolean test = true;  //文档开关

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.qf.personalInformation.controller"))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false).enable(test);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("测试系统接口文档").build();
    }
}

