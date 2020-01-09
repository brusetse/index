package com.bruse.basic.annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DIDemo {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
        ServiceA a = SimpleContainer.getInstance(ServiceA.class);
        a.callB();
    }

    public static void test2() {
        ServiceA a = SimpleContainer2.getInstance(ServiceA.class);
        a.callB();
    }
}

class SimpleContainer {
    public static <T> T getInstance(Class<T> cls) {
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(SimpleInject.class)) {
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    Class<?> fieldCls = f.getType();
                    f.set(obj, getInstance(fieldCls));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SimpleContainer2 {
    private static Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> cls) {
        try {
            boolean singleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if (!singleton) {
                return SimpleContainer.getInstance(cls);
            }
            Object obj = instances.get(cls);
            if (obj != null) {
                return (T) obj;
            }
            synchronized (cls) {
                obj = instances.get(cls);
                if (obj == null) {
                    obj = SimpleContainer.getInstance(cls);
                    instances.put(cls, obj);
                }
            }
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ServiceA {
    @SimpleInject
    ServiceB b;

    public void callB() {
        b.action();
    }
}

@SimpleSingleton
class ServiceB {
    public void action() {
        System.out.println("I'm B");
    }
}

