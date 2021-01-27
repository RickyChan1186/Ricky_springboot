package com;

/**
 * @author ricky
 * @create 2019-11-07 20:38
 */
public class MyFirstThread extends Thread {
    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName()+" is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        MyFirstThread td1 = new MyFirstThread();
        td1.start();

        while (true){
            System.out.println(Thread.currentThread().getName()+" is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
