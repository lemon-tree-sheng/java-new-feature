package com.sheng.java7;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by shengxingyue on 2017/11/6.
 */
public class IO {
    public static void java5() {
        BufferedReader br = null;
        try {
            new BufferedReader(new FileReader("file.txt"));
            StringBuilder sb = new StringBuilder();
            String line      = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void java7() throws IOException{
        // 获取 path 对象
        Path path1 = Paths.get("/Users/shengxingyue/Desktop/add.sql");
        Path path2 = Paths.get("~/Desktop", "add.sql");
        URI u = URI.create("file://~/Desktop/add.sql");
        Path path3 = Paths.get(u);
        Path path4 = FileSystems.getDefault().getPath("~/Desktop","aaa.sql");

        // path、uri、file 之间的转换
        File file = new File("~/Desktop/add.sql");
        Path path5 = file.toPath();
        URI uri = file.toURI();

        // 其他方法
        InputStream is = Files.newInputStream(Paths.get("/Users/shengxingyue/Desktop/add.sql"));
        OutputStream os = Files.newOutputStream(Paths.get("/Users/shengxingyue/Desktop/add.sql"));
        Reader rd = Files.newBufferedReader(Paths.get("/Users/shengxingyue/Desktop/add.sql"));
        Writer wt = Files.newBufferedWriter(Paths.get("/Users/shengxingyue/Desktop/add.sql"));

        // 创建文件、目录
        if (!Files.exists(path1)) {
            /*if (!Files.exists(path)) {
                Files.createFile(path);
                Files.createDirectory(path);
            }*/
        }

        // 临时文件
        /*Files.createTempFile(dir, prefix, suffix);
        Files.createTempFile(prefix, suffix);
        Files.createTempDirectory(dir, prefix);
        Files.createTempDirectory(prefix);*/

        // 复制、移动、删除文件
        /*Files.copy(in, path);
        Files.move(path, path);
        Files.delete(path);*/
    }

    public static void java7_rw() throws IOException{
        // 按字节读
        Path path1 = Paths.get("/Users/shengxingyue/Desktop/add.sql");
        byte[] data = Files.readAllBytes(path1);
        System.out.println(data);

        // 按行读 java8
        List<String> lines = Files.readAllLines(path1);
        for (String line : lines) {
            System.out.println(line);
        }

        // 写入文件
        Files.write(Paths.get("/Users/shengxingyue/Desktop/test.txt"), "hello world".getBytes());

        // 写入文件 按行写入
        Files.write(Paths.get("/Users/shengxingyue/Desktop/test2.txt"), lines, StandardOpenOption.APPEND);
    }

    public static void main(String[] args) throws IOException{
        java7();
    }
}
