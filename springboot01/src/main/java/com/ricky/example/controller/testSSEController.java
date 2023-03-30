package com.ricky.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.TimeUnit;

/**
 * @author ricky
 * @create 2020-03-12 17:01
 */

@Api
@RestController
@RequestMapping(value = "/see/testSSEController")
@CrossOrigin
public class testSSEController {


    @ApiOperation(value = "/push")
    @GetMapping(value = "/push",produces = "text/event-stream;charset=UTF-8")
    public String push(){

        SseEmitter sseEmitter = new SseEmitter(0L);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //随机数
        Double randomNumber = Math.random();

        //实时消息推送
        StringBuilder builder = new StringBuilder();

        builder.append("data: "+randomNumber+"\n\n");//消息数据
        builder.append("id: 1916\n\n"); //事件id

        /**  消息事件
         * 如果不设置event字段，则客户端触发默认事件类型message。
         * 如果设置，则客户端触发事件类型为event字段对应设置的值。
         */
        builder.append("event: sseMessage\n\n"); //消息事件
        builder.append("retry: 10000\n\n"); //设置连接超时时间 毫秒
        builder.append("\n\n"); //该事件类型结束，不同数据类型之间用\n\n(隔一行)来区分

        return builder.toString();

    }
}
