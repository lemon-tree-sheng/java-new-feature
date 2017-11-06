package com.sheng.java7;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by shengxingyue on 2017/11/6.
 * 简写反射带来的异常
 */
public class Reflective_Operation_Exception {

    public static void java5() {
        try {
            Class<?> clazz = Class.forName("com.sheng.test");
            clazz.getMethods()[0].invoke(new Object(), "111");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static void java7() {
        try {
            Class<?> clazz = Class.forName("com.sheng.test");
            clazz.getMethods()[0].invoke(new Object(), "111");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
