package com.ricky.example.task;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ricky
 * @create 2019-09-16 20:45
 */
@Component
public class TestTask {

    //@Scheduled(fixedDelay = 2000)
    public void printfDay() throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("当前系统时间："+new Date());
    }


    //@Scheduled(cron = "*/5 * * * * *")
    @SchedulerLock(name = "channelCronName1", lockAtMostFor = 3*1000)
    public void shedlockMethod1(){
        System.out.println("当前系统时间1："+new Date());
    }

   //@Scheduled(cron = "*/3 * * * * *")
    @SchedulerLock(name = "channelCronName2", lockAtMostFor = 5*1000)
    public void shedlockMethod2(){
        System.out.println("当前系统时间2："+new Date());
    }
}
