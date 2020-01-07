package com.bruse.basic.util.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerException {

    static class TaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println("task A");
        }
    }

    /**
     * 异常会导致整个定时任务终止，所以需要在run方法里捕获异常
     */
    static class TaskB extends TimerTask {
        @Override
        public void run() {
            System.out.println("task B");
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TaskA(), 1, 1000);
        timer.schedule(new TaskB(), 2000, 1000);
    }
}
