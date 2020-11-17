package com.ricky.example.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author ricky
 * @create 2019-09-17 19:34
 */
@Component
public class AsyncTask {


    @Async
    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("任务1完成耗时："+ total);
    }

    @Async
    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("任务2完成耗时："+ total);
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("任务3完成耗时："+ total);
        return new AsyncResult<>("任务3");
    }

    @Async
    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("任务4完成耗时："+ total);
        return new AsyncResult<>("任务4");
    }



}
