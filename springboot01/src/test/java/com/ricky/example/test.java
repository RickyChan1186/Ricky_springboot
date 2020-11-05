package com.ricky.example;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author ricky
 * @create 2020-10-22 21:03
 */
public class test {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
