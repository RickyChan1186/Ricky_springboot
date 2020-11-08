package com.ricky.example.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author ricky
 * @create 2020-03-03 11:31
 */
@Component
public class QueueListener {
    @JmsListener(destination = "common.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")//SendTo的意思是把返回结果推送到out.queue队列
    public void receive(String text){
        System.out.println("QueueListener: consumer-a 收到一条信息: " + text);
       // return "consumer-a received : " + text;
    }
}
