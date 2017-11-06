package com.sheng.java7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by shengxingyue on 2017/11/6.
 * 多个异常捕获可以简写
 */
public class Mul_Exceptions {

    public static void java5() {
        try {
            Thread.sleep(2000);
            FileInputStream fis = new FileInputStream("aaa.txt");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public static void java7() {
        try {
            Thread.sleep(2000);
            FileInputStream fis = new FileInputStream("aaa.txt");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
