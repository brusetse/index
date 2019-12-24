package com.bruse.basic.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayInOutputStream {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try (InputStream input = new FileInputStream("D:\\1.txt"); OutputStream output = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, bytesRead);
            }
            String data = output.toString();
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
