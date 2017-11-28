package com.sheng.java8.lambda;

/**
 * @author shengxingyue, created on 2017/11/28
 */
public class Demo1 {

    /**
     * 声明一个函数式接口
     * @param <T>
     */
    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 使用函数式接口执行判断逻辑
     * @param x
     * @param predicate
     * @return
     */
    public static boolean test(int x, Predicate<Integer> predicate) {
        return predicate.test(x);
    }

    public static void main(String[] args) {
        boolean isAdult = test(17, x -> x >= 18);
        System.out.println(isAdult);
    }

}
