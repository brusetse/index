package com.bruse.patterns.singleton;

/**
 * 饿汉式
 */
public class SingletonHungry {
    private SingletonHungry() {}

    private static SingletonHungry singleton = new SingletonHungry();

    public static SingletonHungry getInstance() {
        return singleton;
    }
}
