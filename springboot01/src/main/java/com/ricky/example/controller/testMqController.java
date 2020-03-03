package com.ricky.example.controller;

import com.ricky.example.rest.Result;
import com.ricky.example.service.ProductMqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author ricky
 * @create 2020-03-01 16:00
 */
@Api(value = "MqController")
@RestController
@RequestMapping(value = "/testMqController")
public class testMqController {

    @Autowired
    private ProductMqService productMqService;

    @ApiOperation(value = "/order")
    @GetMapping(value = "/order")
    public Result order(String message){
        Destination destination = new ActiveMQQueue("common.queue");
        productMqService.sendMessage(destination,message);
        return new Result(true,"消息发送成功");
    }

    @ApiOperation(value = "/common")
    @GetMapping(value = "/common")
    public Result common(String message){

        productMqService.sendMessage(message);
        return new Result(true,"消息发送成功");
    }

    @ApiOperation(value = "/testQueue")
    @GetMapping(value = "/testQueue")
    public Result testQueue(){

        for(int i=0;i<10;i++){
            productMqService.sendMessage("点对点队列消息：queue"+i);
        }
        return new Result(true,"点对点队列消息发送成功");
    }

    @ApiOperation(value = "/testTopic")
    @GetMapping(value = "/testTopic")
    public Result testTopic(){
        for(int i=0;i<10;i++){
            productMqService.sendTopicMessage("订阅队列消息：topic"+i);
        }
        return new Result(true,"消息订阅发送成功");
    }





}
