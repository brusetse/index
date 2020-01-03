package com.bruse.basic.thread;

import java.util.concurrent.Callable;

public class CallableDemo {

    public static void main(String[] args) {
        MyExecutor<Integer> executor = new MyExecutor<>();
        // 子任务
        Callable<Integer> subTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //… 执行 异步 任务
                int millis = (int) (Math.random() * 1000);
                Thread.sleep(millis);
                return millis;
            }
        };
        // 异步调用，返回一个task对象
        MyFuture<Integer> future = executor.execute(subTask);
        // 获取异步调用的结果
        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
