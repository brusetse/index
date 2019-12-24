package com.bruse.basic.io;

import java.io.File;

public class FileTest {

    private static int size;

    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        File file = new File("D:\\1.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.isAbsolute());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
    }

    private static void test2() {
        File file = new File("C:\\Personal\\SyncDir");
        findfile(file);
        System.out.println(size / 1024 / 1024);
    }

    private static void findfile(File file) {
        File[] f = file.listFiles();
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath());
            System.out.println(file.length());
            size += file.length();
        } else {
            for (File file2 : f) {
                findfile(file2);
            }
        }
    }
}
