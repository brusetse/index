package com.bruse.basic.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectorDemo {
    static class Student {
        String name;
        String id;
        double score;
        String grade;

        public Student(String name, String grade, double score) {
            this.name = name;
            this.id = name;
            this.score = score;
            this.grade = grade;
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

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    static List<Student> students = Arrays.asList(
            new Student("zhangsan", "1", 91d),
            new Student("lisi", "2", 89d),
            new Student("wangwu", "1", 50d),
            new Student("zhaoliu", "2", 78d),
            new Student("sunqi", "1", 59d));

    public static void toMap(){
        Map<String,Double> nameScoreMap = students.stream().collect(
                Collectors.toMap(Student::getName, Student::getScore));

        // Map<String, Student> byIdMap = students.stream().collect(
        //         Collectors.toMap(Student::getId, t -> t));

        Map<String, Student> byIdMap = students.stream().collect(
                Collectors.toMap(Student::getId, Function.identity()));

        Map<String,Integer> strLenMap = Stream.of("abc","hello","abc").collect(
                Collectors.toMap(Function.identity(),
                        t->t.length() , (oldValue,value)->value));
    }

    public static void joining() {
        String result = Stream.of("abc", "hello", "abc")
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);
    }

    public static void group(){
        Map<String, List<Student>> groups = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));

        Map<String, Long> gradeCountMap = students.stream().collect(
                groupingBy(Student::getGrade, counting()));

        Map<String, Long> wordCountMap =
                Stream.of("hello","world","abc","hello").collect(
                        groupingBy(Function.identity(), LinkedHashMap::new, counting()));

//		Map<String, Optional<Student>> topStudentMap = students.stream().collect(
//		        groupingBy(Student::getGrade,
//		                maxBy(Comparator.comparing(Student::getScore))));

        Map<String, Student> topStudentMap = students.stream().collect(
                groupingBy(Student::getGrade,
                        collectingAndThen(
                                maxBy(Comparator.comparing(Student::getScore)),
                                Optional::get)));

        Map<String, DoubleSummaryStatistics> gradeScoreStat =
                students.stream().collect(
                        groupingBy(Student::getGrade,
                                summarizingDouble(Student::getScore)));

        Map<String, List<String>> gradeNameMap =
                students.stream().collect(
                        groupingBy(Student::getGrade,
                                mapping(Student::getName, toList())));
        System.out.println(gradeNameMap);
    }

    public static <T> Collector<T, ?, List<T>> collectingAndSort(
            Collector<T, ?, List<T>> downstream,
            Comparator<? super T> comparator) {
        return Collectors.collectingAndThen(downstream, (r) -> {
            r.sort(comparator);
            return r;
        });
    }

    public static <T> Collector<T, ?, List<T>> collectingAndFilter(
            Collector<T, ?, List<T>> downstream,
            Predicate<T> predicate) {
        return Collectors.collectingAndThen(downstream, (r) ->
                r.stream().filter(predicate).collect(Collectors.toList()));
    }

    public static <T> Collector<T, ?, List<T>> collectingAndSkipLimit(
            Collector<T, ?, List<T>> downstream, long skip, long limit) {
        return Collectors.collectingAndThen(downstream, (r) ->
                r.stream().skip(skip).limit(limit).collect(Collectors.toList()));
    }

    public static void collectingAndXXX(){
        Map<String, List<Student>> gradeStudentMap =
                students.stream().collect(
                        groupingBy(Student::getGrade,
                                collectingAndSort(toList(),
                                        Comparator.comparing(Student::getScore).reversed())));

        Map<String, List<Student>> gradeStudentMap2 =
                students.stream().collect(
                        groupingBy(Student::getGrade,
                                collectingAndFilter(toList(), t->t.getScore()<60)));

        Map<String, List<Student>> gradeStudentMap3 =
                students.stream()
                        .sorted(Comparator.comparing(Student::getScore).reversed())
                        .collect(groupingBy(Student::getGrade,
                                collectingAndSkipLimit(toList(), 0, 2)));
    }

    public static void partition(){
        Map<Boolean, List<Student>> byPass = students.stream().collect(
                partitioningBy(t->t.getScore()>=60));

        Map<Boolean, Double> avgScoreMap = students.stream().collect(
                partitioningBy(t->t.getScore()>=60,
                        averagingDouble(Student::getScore)));
    }

    public static void multiLevelGroup(){
        Map<String, Map<Boolean, List<Student>>> multiGroup =
                students.stream().collect(
                        groupingBy(Student::getGrade,
                                partitioningBy(t->t.getScore()>=60)));
    }

    public static void main(String[] args) {
        joining();
    }
}
