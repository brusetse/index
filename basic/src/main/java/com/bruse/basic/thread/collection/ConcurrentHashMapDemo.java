package com.bruse.basic.thread.collection;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        // concurrentUpdate();
        iteratorDemo();
    }

    public static void concurrentUpdate() {
        final Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread() {
                Random rnd = new Random();

                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        map.put(rnd.nextInt(), 1);
                    }
                }
            };
            t.start();
        }
    }

    public static void iteratorDemo() {
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "abstract");
        map.put("b", "basic");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(entry.getKey() + "," + entry.getValue());
                }
            }
        };
        t1.start();
        // 确保线程t1启动
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        map.put("c", "call");
    }

    /**
     * 通过Collections方法生成ConcurrentHashSet
     */
    public static void concurrentHashSet() {
        final ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();
        Set<String> concurrentHashSet = Collections.newSetFromMap(map);
    }
}
