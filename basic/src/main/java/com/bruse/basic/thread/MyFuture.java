package com.bruse.basic.thread;

public interface MyFuture<V> {

    V get() throws Exception;
}
