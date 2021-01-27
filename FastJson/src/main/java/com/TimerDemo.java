package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ricky
 * @create 2019-11-07 20:59
 */
public class TimerDemo {

    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(format.format(date));

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hellow");
            }
        },new Date(), 5000);
    }
}
