package com;

/**
 * @author ricky
 * @create 2019-11-11 20:44
 */
public class countString {
    public static void main(String[] args) {
        Object lock = new Object();
        OneThread oneThread = new OneThread(lock);
        TwoThread twoThread = new TwoThread(lock);

        Thread t1 = new Thread(oneThread);
        Thread t2 = new Thread(twoThread);

        t1.start();
        t2.start();
    }
}
