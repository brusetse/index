package com.bruse.basic.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class TimeDemo {

    public static void main(String[] args) {
        System.out.println("1: " + Instant.now());
        System.out.println("2: " + Instant.ofEpochMilli(System.currentTimeMillis()));
        System.out.println("3: " + LocalDateTime.now());
        System.out.println("4: " + LocalDateTime.of(2020, 1, 1, 1, 1, 1));
        System.out.println("5: " + LocalDateTime.now().toInstant(ZoneOffset.of("+08:00")));
        System.out.println("6: " + ZoneId.of("GMT+08:00"));
        System.out.println("7: " + LocalDate.of(2017, 7, 11));
        System.out.println("8: " + LocalDate.now());
        System.out.println("9: " + LocalTime.of(21, 10, 34));
        System.out.println("10: " + LocalTime.now());
        System.out.println("11: " + ZonedDateTime.now());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.of(2016, 8, 18, 21, 10, 34);
        System.out.println("12: " + formatter.format(ldt));
        String str = "2016-08-18 21:10:34";
        ldt = LocalDateTime.parse(str, formatter);
        System.out.println("13: " + ldt);

        ldt = LocalDateTime.now();
        ldt = ldt.withHour(15).withMinute(20).withSecond(0).withNano(0);
        System.out.println("14: " + ldt);

        ldt = ldt.toLocalDate().atTime(15, 20);
        System.out.println("15: " + ldt);

        ldt = ldt.plusHours(3).plusMinutes(5);
        System.out.println("16: " + ldt);

        ldt = ldt.with(ChronoField.MILLI_OF_DAY, 0);
        System.out.println("17: " + ldt);
    }
}
