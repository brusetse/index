package com.bruse.basic.thread;

public class AssemblePoint {
    private int n;
    public AssemblePoint(int n) {
        this.n = n;
    }
    public synchronized void await() throws InterruptedException {
        if (n > 0) {
            n--;
            if (n == 0) {
                notifyAll();
            } else {
                while (n != 0) {
                    wait();
                }
            }
        }
    }
}

class AssemblePointDemo {
    static class Tourist extends Thread {
        AssemblePoint ap;
        public Tourist(AssemblePoint ap) {
            this.ap = ap;
        }
        @Override
        public void run() {
            try {
                // 模拟先各自独立运行
                System.out.println("start " + Thread.currentThread());
                Thread.sleep((int) (Math.random() * 1000));
                // 集合
                ap.await();
                System.out.println("arrived " + Thread.currentThread());
                // 集合后执行其他操作
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        int num = 10;
        Tourist[] threads = new Tourist[num];
        AssemblePoint ap = new AssemblePoint(num);
        for (int i = 0; i < num; i++) {
            threads[i] = new Tourist(ap);
            threads[i].start();
        }
    }
}