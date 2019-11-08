package com.bruse.basic.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new SignalThread()).start();
        }
    }

    static class SignalThread implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread() + "...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
