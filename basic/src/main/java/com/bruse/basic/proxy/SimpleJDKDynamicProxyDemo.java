package com.bruse.basic.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleJDKDynamicProxyDemo {

    static interface IService {
        public void sayHello();
    }

    static class RealService implements IService {
        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class SimpleInvocationHandler implements InvocationHandler {

        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        // test1();
        test2();
    }

    public static void test1() {
        IService realService = new RealService();
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[]{IService.class}, new SimpleInvocationHandler(realService));
        proxyService.sayHello();
    }

    public static void test2() throws Exception {
        IService realService = new RealService();
        Class<?> proxyCls = Proxy.getProxyClass(IService.class.getClassLoader(), new Class<?>[]{IService.class});
        Constructor<?> ctor = proxyCls.getConstructor(new Class<?>[]{InvocationHandler.class});
        SimpleInvocationHandler handler = new SimpleInvocationHandler(realService);
        IService proxyService = (IService) ctor.newInstance(handler);
        proxyService.sayHello();
    }
}
