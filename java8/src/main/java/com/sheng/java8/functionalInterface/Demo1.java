package com.sheng.java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 使用 jdk 自带的函数式接口
 * 自定用函数式接口
 *
 * @author shengxingyue, created on 2018/1/5
 */
public class Demo1 {

    public static void main(String[] args) {
        // 第一种实现，无论什么情况都返回 true
        Predicate<Integer> predicate0 = param -> true;
        // 第二种实现，需要满足 [50, 100]
        Predicate<Integer> predicate1 = param -> param <= 100 && param >= 50;

        List<Integer> integers = Arrays.asList(123, 23, 45, 78, 89);
        write(integers, predicate0);
        System.out.println();
        write(integers, predicate1);
        System.out.println();


        // 自定义函数式接口
        Printer printer0 = material -> "--" + material + "--";
        Printer printer1 = material -> "**" + material + "**";

        print("sheng", printer0);
        print("wrma", printer1);
        print("foo", material -> "||" + material + "||");
    }

    /**
     * predicate 是一个 jdk 自带的函数式接口，用于进行判断动作
     * @param numbers
     * @param predicate
     */
    public static void write(List<Integer> numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                System.out.print(number + " ");
            }
        }
    }

    /**
     * 使用自定义函数式接口
     * @param material
     * @param printer
     */
    public static void print(String material, Printer printer) {
        System.out.println(printer.print(material));
    }

    /**
     * 自定义函数式接口
     */
    @FunctionalInterface
    interface Printer {
        String print(String material);
    }
}
