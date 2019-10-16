package com.bruse.basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) throws Exception {
        // m1();
        // m2();
        m3();
    }

    private static void m1() throws ExecutionException, InterruptedException {
        int taskSize = 10;
        // 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable<String> c = new MyCallable(i);
            // 执行任务 获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();
        // 获取线程执行结果
        for (Future f : list) {
            System.out.println("res: " + f.get());
        }
    }

    private static void m2() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while (true) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void m3() {
        // 自定义ThreadFactory实现
        ThreadFactory threadFactory = new ThreadFactoryBuilder("demo-pool");
        ExecutorService threadPool = new ThreadPoolExecutor(10, 200, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    static class MyCallable implements Callable<String> {

        private int id;

        MyCallable(int id) {
            this.id = id;
        }

        @Override
        public String call() {
            return id + "";
        }
    }

    static class ThreadFactoryBuilder implements ThreadFactory {

        private String name;
        private int counter;

        ThreadFactoryBuilder(String name) {
            this.name = name;
            this.counter = 1;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName(name + "-" + counter);
            counter++;
            return thread;
        }
    }
}
