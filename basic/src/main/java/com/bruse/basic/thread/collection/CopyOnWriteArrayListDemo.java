package com.bruse.basic.thread.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        System.out.println(list.size());
    }
}
