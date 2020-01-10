package com.bruse.basic.java8.lambda;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicLambda {

    public static void main(String[] args) {
        File f = new File(".");
        File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));

        Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        ExecutorService executor = Executors.newFixedThreadPool(100);
        executor.execute(() -> System.out.println("hello"));
    }
}
