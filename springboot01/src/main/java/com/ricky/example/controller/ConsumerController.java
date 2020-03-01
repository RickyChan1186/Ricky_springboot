package com.ricky.example.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ricky
 * @create 2020-03-01 16:39
 */
@RestController
public class ConsumerController {
    /*
	 * 监听和读取消息
	 */
    @JmsListener(destination="common.queue")
    public void readActiveQueue(String message) {
        System.out.println("接受到：" + message);
        //TODO something
    }
}
