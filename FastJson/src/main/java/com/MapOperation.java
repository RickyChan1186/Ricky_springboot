package com;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author ricky
 * @create 2019-11-17 14:17
 */
public class MapOperation {
    public static void main(String[] args) {
        // 获取当前的日期时间
        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);


        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZonedDateTime date2 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Europe/Paris]");
        System.out.println("当期时区: "+date2);

        LocalDate date3 = LocalDate.now();
        System.out.println(date3);

    }
}
