package com.bruse.basic.java8.stream;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
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
    }

    private static List<Student> students = Arrays.asList(
            new Student("zhangsan", 89d),
            new Student("lisi", 89d),
            new Student("wangwu", 98d));

    public static void basicFilter() {
        List<Student> above90List = students.stream()
                .filter(t -> t.getScore() > 90)
                .collect(Collectors.toList());
    }

    public static void basicMap() {
        List<String> nameList = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void basicFilterAndMap() {
        List<String> above90NameList = students.stream()
                .filter(t -> t.getScore() > 90)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void distinct() {
        List<String> list = Arrays.asList(new String[]{"abc","def","hello","Abc"});
        List<String> retList = list.stream()
                .filter(t -> t.length() < 3)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void sorted() {
        List<Student> list = students.stream()
                .filter(t -> t.getScore() > 90)
                .sorted(Comparator.comparing(Student::getScore)
                        .reversed()
                        .thenComparing(Student::getName))
                .collect(Collectors.toList());
    }

    public static void skipLimit() {
        List<Student> list = students.stream()
                .sorted(Comparator.comparing(Student::getScore)
                        .reversed())
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void peek() {
        List<String> list = students.stream()
                .filter(t -> t.getScore() > 90)
                .peek(System.out::println)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void mapToDouble() {
        double sum = students.stream()
                .mapToDouble(Student::getScore)
                .sum();
    }

    public static void flatMap() {
        List<String> lines = Arrays.asList("hello abc", "老马  编程");
        List<String> words = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.toList());
        System.out.println(words);
    }

    public static void max() {
        Student student = students.stream()
                .max(Comparator.comparing(Student::getScore).reversed())
                .get();
    }

    public static void count() {
        long count = students.stream()
                .filter(t -> t.getScore() > 90)
                .count();
    }

    public static void allMatch() {
        boolean allPass = students.stream()
                .allMatch(t -> t.getScore() >= 60);
    }

    public static void findAny() {
        Optional<Student> student = students.stream()
                .filter(t -> t.getScore() < 90)
                .findAny();
        if (student.isPresent()) {
            // ...
        }
    }

    public static void forEach() {
        students.stream()
                .filter(t -> t.getScore() > 90)
                .forEach(System.out::println);
    }

    public static void toArray() {
        Student[] above90Arr = StreamDemo.students.stream()
                .filter(t -> t.getScore() > 90)
                .toArray(Student[]::new);
    }

    public static void reduceForTopStudent() {
        Student student = students.stream().reduce((accu, t) -> {
            if (accu.getScore() >= t.getScore()) {
                    return accu;
                } else {
                    return t;
                }
            }).get();
    }

    public static void reduceForSumScore() {
        Double sumScore = students.stream().reduce(0d,
                (sum, t) -> sum += t.getScore(),
                (sum1, sum2) -> sum1 += sum2);
    }

    public static void array2stream(){
        File[] files = new File(".").listFiles();
        Arrays.stream(files)
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);
    }

    public static void randomNum(){
        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach(System.out::println);
    }

    public static void oddNums(){
        Stream.iterate(1, t -> t + 2)
                .limit(100)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        flatMap();
        randomNum();
        oddNums();
    }
}
