package com.sheng.java8.defaultMethod;

/**
 * 接口可以有默认方法实现，jdk8 给原有 API 扩展了大量默认方法，比如集合框架
 * @author shengxingyue, created on 2018/1/5
 */
public class Demo1 {

    interface DefaultInterface {
        default void sayHello() {
            System.out.println("hello");
        }
    }

    static class DefaultClass implements DefaultInterface {}

    public static void main(String[] args) {
        DefaultInterface defaultInterface = new DefaultClass();
        defaultInterface.sayHello();
    }
}
