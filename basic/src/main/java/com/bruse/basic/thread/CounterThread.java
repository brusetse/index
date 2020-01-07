package com.bruse.basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {
    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.incr();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.getCount());
    }
}

class Counter {
    private int count;

    public synchronized void incr() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    public void incrBlock() {
        synchronized (this) {
            count++;
        }
    }

    public int getCountBlock() {
        synchronized (this) {
            return count;
        }
    }

    // synchronized同步的对象可以是任意对象
    private Object lock = new Object();

    public void incrBlockObject() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCountBlockObject() {
        synchronized (lock) {
            return count;
        }
    }
}

class StaticCounter {
    private static int count = 0;

    public static synchronized void incr() {
        count++;
    }

    public static synchronized int getCount() {
        return count;
    }

    // synchronized对静态方法保护类对象
    public static void incrBlock() {
        synchronized (StaticCounter.class) {
            count++;
        }
    }

    public static int getCountBlock() {
        synchronized (StaticCounter.class) {
            return count;
        }
    }
}

class LockCounter {
    private final static Lock lock = new ReentrantLock();
    private static int count = 0;

    public static void incr() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static int getCount() {
        return count;
    }
}