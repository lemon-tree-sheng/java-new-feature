package com.sheng.java8.lambda;

import java.util.function.Function;

/**
 * @author shengxingyue, created on 2017/11/28
 */
public class Demo1 {

    public static int add(int x, Function<Integer, Integer> function) {
        return function.apply(x);
    }

    public static void main(String[] args) {
        int result = add(10, x -> x + 20);
        System.out.println(result);
    }

}
