package com.bruse.patterns.singleton;

/**
 * 登记式/静态内部类
 * 懒加载且线程安全
 */
public class SingletonInner {
    private SingletonInner() {}

    private static class SingletonHolder {
        private static final SingletonInner INSTANCE = new SingletonInner();
    }

    public static SingletonInner getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
