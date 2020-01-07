package com.bruse.basic.thread.collection;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.SynchronousQueue;

public class ConcurrentQueueDemo {

    public static void main(String[] args) {
        /**
         * 17.4.1 无锁非阻塞并发队列 原理：循环CAS
         */
        // 基于单向链表
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        // 基于双向链表
        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();

        /**
         * 阻塞队列  原理：ReetrantLock Condition
         * 17.4.2 普通阻塞队列
         */
        // 基于循环数组
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(16);
        // 基于单向链表
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        // 基于双向链表
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        /**
         * 17.4.3 优先级阻塞队列
         */
        // 基于堆
        PriorityQueue priorityQueue = new PriorityQueue();

        /**
         * 17.4.4 延时阻塞队列
         */
        // 基于PriorityQueue
        DelayQueue delayQueue = new DelayQueue();

        /**
         * 17.4.5 其他阻塞队列
         */
        // 不存储元素 用于线程间通信
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        // 基于链表 用于消息传递
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
    }
}
