package com;

import java.util.concurrent.TimeUnit;

/**
 * @author ricky
 * @create 2019-11-11 21:01
 */
public class TwoThread implements Runnable {
    private Object lock;

    public TwoThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("TwoThread is start..");
            try {
                System.out.println("wait 2 minute..");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TwoThread is end..");
            lock.notify();

        }
    }
}
