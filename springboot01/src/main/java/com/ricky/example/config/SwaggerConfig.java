package com.ricky.example.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ricky
 * @create 2019-12-11 22:31
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        // 统一设置返回描述
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(400).message("请求参数有误").build());
        responseMessages.add(new ResponseMessageBuilder().code(401).message("未授权").build());
        responseMessages.add(new ResponseMessageBuilder().code(403).message("禁止访问").build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("请求路径不存在").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("string")).build());

        return new Docket(DocumentationType.SWAGGER_2)
                // 禁用默认返回描述
                .useDefaultResponseMessages(false)
                // 启用新的返回描述
                .globalResponseMessage(RequestMethod.GET, responseMessages)
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PATCH, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                // 设置基本信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns.modular.system.controller"))     //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Api")
                .description("Swagger Api文档")
                .termsOfServiceUrl("https://swagger.io/docs/specification/about/")
                .contact(new Contact("ricky", "https://swagger.io/docs/specification/about/", ""))
                .version("2.0")
                .build();
    }
}
