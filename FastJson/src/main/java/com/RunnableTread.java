package com;

import java.util.concurrent.TimeUnit;

/**
 * @author ricky
 * @create 2019-11-07 20:47
 */
public class RunnableTread {
    public static void main(String[] args) {
        SecondThread t1 = new SecondThread("t1");
        Thread tt = new Thread(t1);
        tt.start();
        try {
            TimeUnit.SECONDS.sleep(10);
            tt.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }
}
