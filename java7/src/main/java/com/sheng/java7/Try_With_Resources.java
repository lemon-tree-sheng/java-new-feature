package com.sheng.java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shengxingyue on 2017/11/3.
 */
public class Try_With_Resources {

    public static void main(String[] args) {

    }

    public static void java5() throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(new File("~/sheng/123.txt"));
            // do something
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
//            is.close(); // 手动关闭
        }
    }

    public static void java7() {
        try(InputStream is = new FileInputStream(new File("~/sheng/123.txt"))) {
            // do something
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
