package com.sheng.java8;

/**
 * Created by shengxingyue on 2017/11/7.
 * 连接多个字符串
 */
public class String_join {

    public static void main(String[] args) {
        String tmp = String.join(",", "a", "b", "c");
        System.out.println(tmp);
    }
}
