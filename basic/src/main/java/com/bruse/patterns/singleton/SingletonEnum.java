package com.bruse.patterns.singleton;

/**
 * 枚举方式
 * 简洁 线程安全 支持序列化 Effective Java推荐
 */
public enum SingletonEnum {
    // 枚举元素即Singleton实例
    INSTANCE;

    public void doSomething() {
        System.out.println("枚举方式实现单例");
    }

    public static void main(String[] args) {
        SingletonEnum singleton = SingletonEnum.INSTANCE;
        singleton.doSomething();
    }
}
