package com.bruse.basic.io;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i);
    }
}
