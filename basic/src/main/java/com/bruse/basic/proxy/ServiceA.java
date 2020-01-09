package com.bruse.basic.proxy;

import com.bruse.basic.annotation.SimpleInject;

public class ServiceA {

    @SimpleInject
    ServiceB b;

    public void callB(){
        b.action();
    }

    public ServiceB getB() {
        return b;
    }
}
