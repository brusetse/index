package com.bruse.patterns.singleton;

/**
 * 懒汉式
 */
public class SingletonLazy {
    private SingletonLazy() {}

    private volatile static SingletonLazy singleton;

    public static SingletonLazy getInstance() {
        if (singleton == null) {
            // 线程安全
            synchronized (SingletonLazy.class) {
                singleton = new SingletonLazy();
            }
        }
        return singleton;
    }
}
