package com.bruse.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        // test1();
        // test2();
        // test3();
        // test4();
        test5();
    }

    public static void test1() throws Exception {
        Class<Integer> intClass = int.class;
        System.out.println(intClass.getName());
        Class<?> cls = Class.forName("java.util.HashMap");
        System.out.println(cls.getName());
    }

    public static void test2() throws Exception {
        List<String> obj = Arrays.asList(new String[]{"LeBron", "Kevin"});
        Class<? extends List> cls = obj.getClass();
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + "-" + field.get(obj));
            int mod = field.getModifiers();
            System.out.println(Modifier.toString(mod));
        }
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }

    public static void test3() throws Exception {
        Class<?> cls = Integer.class;
        try {
            Method method = cls.getMethod("parseInt", new Class[]{String.class});
            System.out.println(method.invoke(null, "123"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void test4() throws Exception {
        HashMap<String, Integer> map = HashMap.class.newInstance();
        map.put("hello", 123);

        Constructor<StringBuilder> constructor = StringBuilder.class.getConstructor(new Class[]{int.class});
        StringBuilder builder = constructor.newInstance(123);

        List list = new ArrayList();
        Class cls = Class.forName("java.util.ArrayList");
        if (cls.isInstance(list)) {
            System.out.println("array list");
        }
        // 检查参数类型cls能否赋给当前Class类型的变量
        Object.class.isAssignableFrom(String.class);
        String.class.isAssignableFrom(String.class);
        List.class.isAssignableFrom(ArrayList.class);
    }

    public static void test5() throws Exception {
        Class<HashMap> cls = HashMap.class;
        Class<? super HashMap> superclass = cls.getSuperclass();
        System.out.println(superclass.getName());
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface.getName());
        }
    }

    public static void test0() throws Exception {

    }
}
