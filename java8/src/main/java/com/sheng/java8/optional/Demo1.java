package com.sheng.java8.optional;

import java.util.Optional;

/**
 * optinal 的使用
 * @author shengxingyue, created on 2018/1/5
 */
public class Demo1 {

    public static void main(String[] args) {
        Integer a = null;
        Integer b = 5;

        Optional<Integer> value1 = Optional.ofNullable(a);
        Optional<Integer> value2 = Optional.of(b);

        System.out.println(sum(value1, value2));
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("1st param is present:" + a.isPresent());
        System.out.println("2nd param is present:" + b.isPresent());

        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();

        return value1 + value2;
    }
}
