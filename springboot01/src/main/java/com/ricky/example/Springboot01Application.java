package com.ricky.example;


import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.Queue;
import javax.servlet.MultipartConfigElement;

@MapperScan("com.ricky.example.dao")
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@EnableScheduling
@EnableAsync
@EnableJms //开启支持jms
public class Springboot01Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot01Application.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("10240KB");
		factory.setMaxRequestSize("1024000KB");
		return factory.createMultipartConfig();
	}

	//初始化一个MQ队列的Bean,交给Spring管理,方便后续注入
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("common.queue");
	}

}
