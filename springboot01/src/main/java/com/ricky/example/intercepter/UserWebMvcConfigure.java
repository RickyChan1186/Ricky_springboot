package com.ricky.example.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ricky
 * @create 2019-09-05 19:47
 */
@Configuration
public class UserWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //加载拦截器和url
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/intercepter/*");
        registry.addInterceptor(new EventIntercepter()).addPathPatterns("/intercepter/*");

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
