package com.bruse.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class InOutputStreamReadWriter {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("D:\\1.txt"), StandardCharsets.UTF_8)) {
            String str = "hello writer!";
            writer.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try (Reader reader = new InputStreamReader(new FileInputStream("D:\\1.txt"), StandardCharsets.UTF_8)) {
            char[] buf = new char[1024];
            int charsRead = reader.read(buf);
            System.out.println(new String(buf, 0, charsRead));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
