package com.bruse.basic.util.timer;

import java.util.Timer;
import java.util.TimerTask;

public class BasicTimer {

    static class DelayTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("delay task");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new DelayTask(), 1000);
        Thread.sleep(2000);
        timer.cancel();
    }
}
