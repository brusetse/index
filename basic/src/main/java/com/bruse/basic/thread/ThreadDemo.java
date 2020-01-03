package com.bruse.basic.thread;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("thread name: " + Thread.currentThread().getName());
        System.out.println("hello");
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        System.out.println("thread state before start: " + thread.getState());
        thread.start();
        System.out.println("thread state after start: " + thread.getState());
        System.out.println("thread isAlive: " + thread.isAlive());
        System.out.println("thread isDaemon: " + thread.isDaemon());
    }
}

class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("thread name: " + Thread.currentThread().getName());
        System.out.println("hello");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunnableDemo());
        thread.start();
        thread.run();
        thread.join();
    }
}