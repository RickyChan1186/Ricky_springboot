package com.ricky.example.controller;

import com.ricky.example.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author ricky
 * @create 2019-09-17 19:38
 */
@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;


    @GetMapping(value = "/testAsync")
    public Object testAsync() throws InterruptedException {
        Map<String,Object> map = new HashMap<>();

        long begin = System.currentTimeMillis();
        asyncTask.task1();
        asyncTask.task2();
        long end = System.currentTimeMillis();
        long total = end - begin;

        System.out.println("总耗时时间："+total);

        map.put("total",total);
        map.put("result",true);
        return map;
    }


    @GetMapping(value = "/testAsync2")
    public Object testAsync2() throws InterruptedException {
        Map<String,Object> map = new HashMap<>();

        long begin = System.currentTimeMillis();
        Future<String> task3 = asyncTask.task3();
        Future<String> task4 = asyncTask.task4();
        long end = System.currentTimeMillis();

        for(;;){
            if(task3.isDone() && task4.isDone()){
                break;
            }
        }

        long total = end - begin;
        System.out.println("总耗时时间："+total);

        map.put("total",total);
        map.put("result",true);
        return map;
    }
}
