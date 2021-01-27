package com;

/**
 * @author ricky
 * @create 2019-11-11 20:58
 */
public class OneThread implements Runnable {

    private Object lock;

    public OneThread(Object lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("OneThread is start..");
            try {
                System.out.println("OneThread is wait..");
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("OneThread is end..");
        }

    }
}
