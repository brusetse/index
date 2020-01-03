package com.bruse.basic.thread;

public class InterruptDemo {

    public static void main(String[] args) {
        interruptWaiting();
    }

    public static void interruptWaiting() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(isInterrupted());
                }
            }
        };
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        t.interrupt();
    }
}

class InterruptRunnableDemo extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // ...单次循环代码
        }
        System.out.println("done");
    }
}

class InterruptWaitingDemo extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try { //模拟任务代码
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //… 清理操作
                // 重设中断标志位
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(isInterrupted());
    }
}

class InterruptSynchronizedDemo {
    private static Object lock = new Object();

    private static class A extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                while (!Thread.currentThread().isInterrupted()) {
                }
            }
            System.out.println(" exit");
        }
    }

    public static void test() throws InterruptedException {
        synchronized (lock) {
            A a = new A();
            a.start();
            Thread.sleep(1000);
            a.interrupt();
            a.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}