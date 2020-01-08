package com.bruse.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SimpleFormatterDemo {

    static class Student {
        @Label("姓名")
        String name;

        @Label("出生日期")
        @Format(pattern="yyyy/MM/dd")
        Date born;

        @Label("分数")
        double score;

        public Student() {
        }

        public Student(String name, Date born, Double score) {
            super();
            this.name = name;
            this.born = born;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", born=" + born + ", score=" + score + "]";
        }
    }

    public static void main(String[] args) {
        Student zhangsan = new Student("张三", new Date(), 80.9d);
        System.out.println(SimpleFormatter.format(zhangsan));
    }
}

class SimpleFormatter {

    private static Object formatDate(Field f, Object value) {
        Format format = f.getAnnotation(Format.class);
        if (format != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
            sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            return sdf.format(value);
        }
        return value;
    }

    public static String format(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            for (Field f : cls.getDeclaredFields()) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                Label label = f.getAnnotation(Label.class);
                String name = label != null ? label.value() : f.getName();
                Object value = f.get(obj);
                if (value != null && f.getType() == Date.class) {
                    value = formatDate(f, value);
                }
                sb.append(name + "：" + value + "\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Label {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Format {
    String pattern() default "yyyy-MM-dd HH:mm:ss";
    String timezone() default "GMT+8";
}