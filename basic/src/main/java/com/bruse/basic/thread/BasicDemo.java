package com.bruse.basic.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class BasicDemo {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            Thread.sleep(sleepSeconds);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 线程池
        // ExecutorService executor = Executors.newSingleThreadExecutor();
        // 简单实现 继承 AbstractExecutorService
        ExecutorService executor = new SimpleExecutorService();
        Future<Integer> future = executor.submit(new Task());
        //模拟执行其他任务
        Thread.sleep(100);
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
