package com.bruse.basic.thread;

public class MyLatch {

    private int count;

    public MyLatch(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            wait();
        }
    }

    public synchronized void countDown() {
        count--;
        if (count <= 0) {
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int workerNum = 100;
        MyLatch latch = new MyLatch(workerNum);
        Worker[] workers = new Worker[workerNum];
        for (int i = 0; i < workerNum; i++) {
            workers[i] = new Worker(latch);
            workers[i].start();
        }
        latch.await();
        System.out.println(" collect worker results");
    }
}

class Worker extends Thread {

    MyLatch latch;

    public Worker(MyLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            //simulate working on task
            Thread.sleep((int) (Math.random() * 1000));
            this.latch.countDown();
        } catch (InterruptedException e) {
        }
    }
}

class RacerWithLatchDemo {
    static class Racer extends Thread {
        MyLatch latch;

        public Racer(MyLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                this.latch.await();
                System.out.println(" start run " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        MyLatch latch = new MyLatch(1);
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(latch);
            racers[i].start();
        }
        Thread.sleep(1000);
        latch.countDown();
    }
}