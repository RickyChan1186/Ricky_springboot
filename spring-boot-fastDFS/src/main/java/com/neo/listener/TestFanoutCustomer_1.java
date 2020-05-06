package com.neo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ricky
 * @create 2020-04-27 10:36
 */
//Fanout队列模式

@RabbitListener(queues = "test_queue02")
@Component
public class TestFanoutCustomer_1 {

    @RabbitHandler
    public void handleMessage(String msg){
        System.out.println("test_queue02接收的消息内容是："+msg);

    }
}
