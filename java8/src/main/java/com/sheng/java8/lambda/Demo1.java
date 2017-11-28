package com.sheng.java8.lambda;

/**
 * @author shengxingyue, created on 2017/11/28
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread demoThread = new Thread(new DemoThread(), "demo-thread");
        demoThread.start();
    }
}

/**
 * java8之前新写一个线程
 */
class DemoThread implements Runnable {
    @Override
    public void run() {
        System.out.println("do something");
    }
}
