package com.bruse.basic.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedReadWriter {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\1.txt"))) {
            for (int i = 1; i < 5; i++) {
                writer.write("name" + i + "," + i + "," + (i * 10));
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\1.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
