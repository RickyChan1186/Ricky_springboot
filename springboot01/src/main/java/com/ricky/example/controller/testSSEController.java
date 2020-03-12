package com.ricky.example.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ricky
 * @create 2020-03-12 17:01
 */

@Api
@RestController
@RequestMapping(value = "/testSSEController")
public class testSSEController {


    @GetMapping(value = "/push",produces = "text/event-stream;charset=UTF-8")
    public String push(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "随机数："+Math.random();
    }
}
