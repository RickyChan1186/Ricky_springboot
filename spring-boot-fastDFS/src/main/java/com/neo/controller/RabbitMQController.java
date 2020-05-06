package com.neo.controller;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ricky
 * @create 2020-04-27 9:46
 */
@RestController
public class RabbitMQController {

    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;


    @GetMapping(value = "/sendDirectQueneMsg")
    public void sendDirectQueneMsg(String msg){

        rabbitMessagingTemplate.convertAndSend("test_queue01",msg);
    }

    @GetMapping(value = "/sendFanoutMsg")
    public void sendFanoutMsg(String msg){
        rabbitMessagingTemplate.convertAndSend("test_fanout_exchange","",msg);
    }


    @GetMapping(value = "/sendTopicMsg")
    public void sendTopicMsg(int type){
        switch (type){
            case 1:
                rabbitMessagingTemplate.convertAndSend("test_topic_exchange","aaa.bbb","test topic 1111");
                break;
            case 2:
                rabbitMessagingTemplate.convertAndSend("test_topic_exchange","aaa.bbb.ccc","test topic 2222");
                break;
            case 3:
                rabbitMessagingTemplate.convertAndSend("test_topic_exchange","bbb.aaa","test topic 3333");
                break;
        }

    }
}
