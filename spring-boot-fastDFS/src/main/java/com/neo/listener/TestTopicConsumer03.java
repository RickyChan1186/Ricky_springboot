package com.neo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ricky
 * @create 2020-04-27 10:45
 */
@RabbitListener(queues = "test_topic_queue03")
@Component
public class TestTopicConsumer03 {
    @RabbitHandler
    public void handle(String msg){
        System.out.println("TopicConsumer03 - routingkey:bbb.aaa");
        System.out.println("接收消息为:" + msg);
        System.out.println("------------------------------------");
    }
}