package com.sheng.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author shengxingyue, created on 2018/1/5
 */
public class Demo1 {
    public static void main(String[] args) {
        // forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // map
        List<Integer> list = Arrays.asList(2, 3, 4, 2, 5, 5);
        List<Integer> result = list.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        result.forEach(System.out::println);

        // filter
        List<String> stringList = Arrays.asList("liyhih", "", "hlo;ikh;ioh", "kjh;klh", "");
        long count = stringList.stream().filter(i -> i.equals("")).count();
        System.out.println(count);

        // limit
        random.ints().limit(5).forEach(System.out::println);

        // sorted
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::println);

        // summaryStatics
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMax());
    }
}
