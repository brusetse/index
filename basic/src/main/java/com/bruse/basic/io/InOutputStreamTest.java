package com.bruse.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class InOutputStreamTest {

    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

    public static void test1() {
        try {
            OutputStream output = new FileOutputStream("D:\\1.txt");
            String data = "hello world!";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            output.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            InputStream input = new FileInputStream("D:\\1.txt");
            byte[] buf = new byte[1024];
            int bytesRead = input.read(buf);
            String data = new String(buf, 0, bytesRead, "UTF-8");
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try {
            InputStream input = new FileInputStream("D:\\1.txt");
            byte[] buf = new byte[1024];
            int b = -1;
            int byteRead = 0;
            while ((b = input.read()) != -1) {
                buf[byteRead++] = (byte) b;
            }
            String data = new String(buf, 0, byteRead, "UTF-8");
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
