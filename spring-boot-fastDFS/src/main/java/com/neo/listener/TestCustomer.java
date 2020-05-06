package com.neo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ricky
 * @create 2020-04-27 9:42
 */
//direct-直接消费者类
@RabbitListener(queues = "test_queue01") //声明那个队列接收
@Component
public class TestCustomer {
    @RabbitHandler
    public void handleMessage(String msg){
        System.out.println("接收的消息内容是："+msg);

    }
}
