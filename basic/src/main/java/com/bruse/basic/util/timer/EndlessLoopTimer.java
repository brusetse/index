package com.bruse.basic.util.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 一个Timer对象只有一个Timer线程，这意味着，定时任务不能耗时太长，更不能是无限循环。
 */
public class EndlessLoopTimer {

    static class LoopTask extends TimerTask {
        @Override
        public void run() {
            while (true) {
                try {
                    //模拟执行任务
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //永远也没有机会执行
    static class ExampleTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new LoopTask(), 10);
        timer.schedule(new ExampleTask(), 100);
    }
}
