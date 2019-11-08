package com.bruse.basic.lock;

public class ThreadTest {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new MyThread()).start();
        }
        System.out.println("active count " + Thread.activeCount());
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "...");
            try {
                Thread.sleep(1000);
                Thread.interrupted();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " over");
        }
    }
}
