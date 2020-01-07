package com.bruse.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        // 使用单线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 固定数目线程 队列为LinkedBlockingQueue 问题：队列过长
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        // 线程数不限制 keepAliveTime为60秒 队列为SynchronousQueue 问题：线程过多
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    }
}
