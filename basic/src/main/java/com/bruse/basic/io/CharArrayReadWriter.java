package com.bruse.basic.io;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class CharArrayReadWriter {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try (Reader reader = new InputStreamReader(new FileInputStream("D:\\1.txt"), StandardCharsets.UTF_8); CharArrayWriter writer = new CharArrayWriter()) {
            char[] buf = new char[1024];
            int charsRead = 0;
            while ((charsRead = reader.read(buf)) != -1) {
                writer.write(buf, 0, charsRead);
            }
            System.out.println(writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
