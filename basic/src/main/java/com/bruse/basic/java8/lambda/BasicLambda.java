package com.bruse.basic.java8.lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambda {

    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        // test4();
        // test5();
        test6();
    }

    public static void test1() {
        File f = new File(".");
        File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));
        Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        ExecutorService executor = Executors.newFixedThreadPool(100);
        executor.execute(() -> System.out.println("hello"));
    }

    public static void test2() {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 89d), new Student("wangwu", 98d));
        students = filter(students, t -> t.score > 90);
    }

    public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
        List<E> retList = new ArrayList<>();
        for (E e : list) {
            if (pred.test(e)) {
                retList.add(e);
            }
        }
        return retList;
    }

    static class Student {
        String name;
        double score;

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public static String getCollegeName() {
            return "Laoma School";
        }
    }

    public static void test3() {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 89d), new Student("wangwu", 98d));
        List<String> names = map(students, t -> t.getName());
        names = map(students, Student::getName);
        // 将学生名称转换为大写
        students = map(students, t -> new Student(t.getName().toUpperCase(), t.getScore()));
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> retList = new ArrayList<>(list.size());
        for (T e : list) {
            retList.add(mapper.apply(e));
        }
        return retList;
    }

    public static void test4() {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 89d), new Student("wangwu", 98d));
        foreach(students, t -> t.setName(t.getName().toUpperCase()));
    }

    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }

    public static void test5() {
        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 89d), new Student("wangwu", 98d));
        List<String> names = map(students, Student::getName);
        // 对于静态方法，下面两条语句等价
        Supplier<String> s = Student::getCollegeName;
        s = () -> Student.getCollegeName();
        // 对于实例方法，下面两条语句等价
        Function<Student, String> f = Student::getName;
        f = t -> t.getName();
        // 对于BiConsumer，下面两条语句等价
        BiConsumer<Student, String> c = Student::setName;
        c = (t, name) -> t.setName(name);

        Student t = new Student("zhangsan", 89d);
        Supplier<String> s2 = t::getName;
        s2 = () -> t.getName();

        Consumer<String> c2 = t::setName;
        c2 = name -> t.setName(name);
        // 构造方法
        BiFunction<String, Double, Student> b = (name, score) -> new Student(name, score);
        b = Student::new;
    }

    public static void test6() {
        File f = new File(".");
        File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));
        Arrays.sort(files, Comparator.comparing(File::getName));

        List<Student> students = Arrays.asList(new Student("zhangsan", 89d),
                new Student("lisi", 89d), new Student("wangwu", 98d));
        students.sort(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getName));
    }
}