package com.bruse.basic.loader;

public class CIInitDemo {

    public static class Hello {
        static {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String className = CIInitDemo.class.getName() + "$Hello";
        try {
            // ClassLoader的loadClass不会执行类的初始化代码
            Class<?> cls = cl.loadClass(className);
            // Class<?> cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
