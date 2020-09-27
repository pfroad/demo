package com.pfroad.demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JDK8TimeTest {
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        // An instantaneous point on the time-line.
        Instant now = Instant.now();
        Instant.class.getInterfaces();
        System.out.println(now.toEpochMilli());
        Instant inst = now.plus(2, ChronoUnit.DAYS);
        now.getClass().getGenericInterfaces();
//        System.out.println(inst.toString());
//        Date date = Date.from(now);
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)));
//
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        System.out.println("Time:" + time);

        System.out.println(fromLocalDateTime(dateTime));
//        System.out.println(dateTime);
//        dateTime.plusHours(2);
        System.out.println(dateTime.plus(Period.ofDays(2)));
//
//        System.out.println(dateTimeFormatter.format(dateTime));

//        A clock providing access to the current instant, date and time using a time-zone.
//        Clock clock = Clock.system(ZoneId.systemDefault());
//        clock.instant();
        ZoneId.of("Asia/Shanghai");
        Date date1 = stringToDate("2018-06-12 23:11:01");
        String dateStr = dateFormat(date1);
        LocalDate localDate = localDateFromDate(date1);
        System.out.println(localDate.getDayOfYear());
        LocalTime localTime = localTimeFromDate(date1);
        System.out.println(localDate);
        System.out.println(localTime.getSecond());
        Date d2 = fromLocalTime(localTime);
        System.out.println(d2);
    }

    public static Date stringToDate(String dateStr) {
        LocalDateTime dateTime = LocalDateTime.parse(dateStr, dateTimeFormatter);
        return Date.from(dateTime.toInstant(ZoneOffset.ofHours(8)));
    }

    public static String dateFormat(Date date) {
        return dateTimeFormatter.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }

    public static LocalDateTime fromDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date fromLocalDateTime(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate localDateFromDate(Date date) {
        return LocalDate.from(fromDate(date).toLocalDate());
    }

        public static Date fromLocalDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalTime localTimeFromDate(Date date) {
        return LocalTime.from(fromDate(date).toLocalTime());
    }

    public static Date fromLocalTime(LocalTime localTime) {
        return Date.from(localTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
    }
}
