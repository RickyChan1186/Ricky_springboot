package com.ricky.example.task;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ricky
 * @create 2019-09-16 20:45
 */
@Component
public class TestTask {

    //@Scheduled(fixedDelay = 2000)
    public void printfDay() throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("当前系统时间："+new Date());
    }
}
