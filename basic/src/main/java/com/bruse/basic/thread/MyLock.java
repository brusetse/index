package com.bruse.basic.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyLock {

    private AtomicInteger status = new AtomicInteger(0);

    public void lock() {
        if (!status.compareAndSet(0, 1)) {
            Thread.yield();
        }
    }

    public void unlock() {
        status.compareAndSet(1, 0);
    }
}
