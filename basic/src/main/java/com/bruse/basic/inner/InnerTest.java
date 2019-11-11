package com.bruse.basic.inner;

public class InnerTest {
    private static int a = 1;
    private int b = 2;

    public static void main(String[] args) {
        new InnerTest().test1();
        System.out.println("----------------------------");
        new InnerTest().test2();
        System.out.println("----------------------------");
        new InnerTest().test3(3);
        System.out.println("----------------------------");
        /**
         * 匿名内部类
         */
        new InnerTest().test4(new Bird() {
            @Override
            public String getName() {
                return "Kun";
            }

            @Override
            public int fly() {
                return 100;
            }
        });
    }

    private void test1() {
        Inner inner = new Inner();
        inner.print();
    }

    private void test2() {
        Inner2 inner2 = new Inner2();
        inner2.print();
    }

    private void test3(int c) {
        /**
         * 局部内部类
         */
        class Inner3 {
            public void print() {
                System.out.println(c);
            }
        }

        Inner3 inner3 = new Inner3();
        inner3.print();
    }

    private void test4(Bird bird) {
        System.out.println(bird.getName() + " fly " + bird.fly() + " meters");
    }

    /**
     * 静态内部类
     */
    public static class Inner {
        public void print() {
            System.out.println(a);
            // 静态内部类只能调用外部类静态变量和方法
            // System.out.println(b);
        }
    }

    /**
     * 动态内部类
     */
    public class Inner2 {
        public void print() {
            System.out.println(a);
            System.out.println(b);
        }
    }
}

abstract class Bird {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}