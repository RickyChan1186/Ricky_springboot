package com.ricky.example.service.Imp;

import com.ricky.example.service.ProductMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author ricky
 * @create 2020-03-01 15:50
 */
@Service
public class ProductMqServiceImp implements ProductMqService {


    //封装好的一个模板调用方法
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //启动类定义好的bean对象
    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;


    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.queue,message);

    }

    @Override
    public void sendTopicMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.topic,message);
    }


}
