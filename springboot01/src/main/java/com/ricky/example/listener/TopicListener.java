package com.ricky.example.listener;

import org.springframework.stereotype.Component;

/**
 * @author ricky
 * @create 2020-03-03 11:33
 */
@Component
public class TopicListener {

    //@JmsListener(destination = "common.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }

    //@JmsListener(destination = "common.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive2(String text){
        System.out.println("TopicListener: consumer-b 收到一条信息: " + text);
    }
}
