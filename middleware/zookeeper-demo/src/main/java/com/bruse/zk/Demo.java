package com.bruse.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Demo {

    public static void main(String[] args) throws Exception {
        // 创建zookeeper客户端
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.1.188:2181", retryPolicy);
        client.start();
        // 创建分布式锁，锁空间的根节点路径为/curator/lock
        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");
        mutex.acquire();
        // 获取锁，进行业务流程
        System.out.println("Enter mutex");
        Thread.sleep(30000);
        // 完成业务流程，释放锁
        mutex.release();
        System.out.println("Leave mutex");
        // 关闭客户端
        client.close();
    }
}
