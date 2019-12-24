package com.bruse.basic.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Producer {

    public static void main(String[] args) throws InterruptedException {
        try {
            BasicQueue queue = new BasicQueue("D:\\BasicQueue\\", "task");
            int i = 0;
            Random rnd = new Random();
            while (true) {
                String msg = " task " + (i++);
                queue.enqueue(msg.getBytes(StandardCharsets.UTF_8));
                System.out.println(" produce: " + msg);
                Thread.sleep(rnd.nextInt(1000));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
