package com;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ricky
 * @create 2020-11-25 12:38
 */
public class CallableTest {

    public static void main(String[] args) throws Exception {
        Callable<Integer> call = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("thread start .. ");
                Thread.sleep(2000);
                return 1;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(call);
        Thread t = new Thread(task);

        t.start();
        System.out.println("do other thing .. ");
        System.out.println("拿到线程的执行结果 ： " + task.get());
    }
}
