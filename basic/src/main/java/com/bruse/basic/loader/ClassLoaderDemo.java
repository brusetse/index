package com.bruse.basic.loader;

public class ClassLoaderDemo {

    /**
     * 由BootstrapLoader加载的类输出为null
     */
    public static void main(String[] args) {
        ClassLoader cl = ClassLoaderDemo.class.getClassLoader();
        while (cl != null) {
            System.out.println(cl.getClass().getName());
            cl = cl.getParent();
        }
        System.out.println(String.class.getClassLoader());

        ClassLoader cl2 = ClassLoader.getSystemClassLoader();
        try {
            Class<?> cls = cl2.loadClass("java.util.ArrayList");
            ClassLoader actualLoader = cls.getClassLoader();
            System.out.println(actualLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
