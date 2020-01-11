package com.bruse.basic.java8.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class BasicCompletableFutureDemo {

    private static ExecutorService executor =
            Executors.newFixedThreadPool(10);

    private static Random rnd = new Random();

    static int delayRandom(int min, int max) {
        int milli = max > min ? rnd.nextInt(max - min) : 0;
        try {
            Thread.sleep(min + milli);
        } catch (InterruptedException e) {
        }
        return milli;
    }

    static Supplier<Integer> externalTask = () -> delayRandom(20, 2000);

    public static Future<Integer> callExternalService(){
        return CompletableFuture.supplyAsync(externalTask, executor);
    }
}
