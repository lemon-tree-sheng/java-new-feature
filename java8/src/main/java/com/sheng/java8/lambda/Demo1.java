package com.sheng.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author shengxingyue, created on 2017/11/28
 */
public class Demo1 {

    public static void main(String[] args) {

        // 最贴近 java7 的写法
        Hello hello0 = (String to) -> { System.out.println("hello " + to); };
        // 参数只有一个时括号可选, 不管几个参数，类型可选，函数体只有一句时大括号可选，函数只有一句时，return 可选
        Hello hello1 = to -> System.out.println("hello " + to);

        sayHello("sheng", hello0);
        sayHello("wrma", hello1);
        // lambda 隐式作为函数式接口的实现
        sayHello("foo", to -> System.out.println("haha " + to));

        // 简单使用方法引用来简化 lambda
        List<String> arr = Arrays.asList("sheng", "wrma");
        arr.forEach(System.out::println);
    }

    public static void sayHello(String to, Hello hello) {
        hello.sayHello(to);
    }

    /**
     * 函数式接口
     */
    @FunctionalInterface
    interface Hello {
        void sayHello(String to);
    }

}
