package com;

import java.util.concurrent.TimeUnit;

/**
 * @author ricky
 * @create 2019-11-07 20:46
 */
public class SecondThread implements Runnable {

    private String TreadName;

    private static String stop = "N";

    public void setStopMethod(){
        stop = "Y";
    }

    public  SecondThread(String TreadName){
        this.TreadName = TreadName;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(TreadName +" is running");
            if(!Thread.interrupted()){
                System.out.println("Thread is end...");
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }


        }
    }
}
