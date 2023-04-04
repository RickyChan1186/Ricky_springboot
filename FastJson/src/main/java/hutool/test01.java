package hutool;

import cn.hutool.core.date.ChineseDate;

import java.util.Date;

/**
 * @author ricky
 * @create 2021-06-01 9:49
 */
public class test01 {


    public static void main(String[] args) {
        ChineseDate chineseDate = new ChineseDate(new Date());
        System.out.println(chineseDate.getChineseDay());



    }


}
