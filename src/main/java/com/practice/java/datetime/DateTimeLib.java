package com.practice.java.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class DateTimeLib {

    public static void main(String[] args) {

        // Date & SimpleDateFormatter example
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Simple Date format: "+dateFormat.format(date));

        dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Simple Date Format Time: " + dateFormat.format(date));

        // Date Time Lib example
        System.out.println(Calendar.getInstance().getTime());
        // LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println("Local Date: "+ localDate);

        // LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println("Local Time: "+ localTime);

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Date Time: "+ localDateTime);

        // creating local date
        LocalDate localDate1 = LocalDate.now();
        //using day of the year
        localDate1 = LocalDate.ofYearDay(2018, 35);
        System.out.println("using day of the year: "+localDate1);

        localDate1 = LocalDate.of(2018, 05, 23);
        System.out.println(localDate1);

        // get methods
        System.out.println("local date getMonth(): "+ localDate1.getMonth());
        System.out.println("local date getMonthValue(): "+localDate1.getMonthValue());
        System.out.println("local date getDayOfWeek(): "+localDate1.getDayOfWeek());
        System.out.println("local date getDayOfYear(): "+localDate1.getDayOfYear());
        System.out.println("local date getMonth using Chronofield: "+localDate1.get(ChronoField.MONTH_OF_YEAR));

        // date modify
        LocalDate localDate2 = LocalDate.now();
        System.out.println("localdate.plusDays(4): "+localDate2.plusDays(4));
        System.out.println("localdate.plusMonths(2): "+localDate2.plusMonths(2));
        System.out.println("localdate.plusYears(2): "+localDate2.plusYears(2));
        System.out.println("localdate.minusDays(4): "+localDate2.minusDays(4));
        System.out.println("localdate.minusMonths(2): "+localDate2.minusMonths(2));
        System.out.println("localdate.minusYears(2): "+localDate2.minusYears(2));

        // Local Time
        LocalTime localTime1 = LocalTime.now();
        localTime1 = LocalTime.of(15, 18);
        System.out.println("local time: "+ localTime1);
        localTime1 = LocalTime.of(15, 18, 22);
        System.out.println("local time: "+ localTime1);
        localTime1 = LocalTime.of(15, 18, 22, 22222);
        System.out.println("local time: "+ localTime1);

        // get methods
        System.out.println("get hours: "+ localTime1.getHour());
        System.out.println("get Minute: "+ localTime1.getMinute());
        System.out.println("get Second: "+ localTime1.getSecond());
        System.out.println("get nano: "+ localTime1.getNano());

        // time modify
        System.out.println("plusHours(2): "+localTime1.plusHours(2));
        System.out.println("plusMinutes(10): "+localTime1.plusMinutes(10));
        System.out.println("plusSeconds(30): "+localTime1.plusSeconds(30));
        System.out.println("plusNanos(345676543): "+localTime1.plusNanos(345676543));

        // Duration example
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now().plusHours(2);
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println("duration betwn 2 local date time objects" + duration.toHours());

        // Instant example
        Instant timestamp = Instant.now();
        System.out.println("instant timestamp: "+timestamp.getNano());

        Instant timestamp1 = Instant.now().plusSeconds(3600);
        Duration duration1 = Duration.between(timestamp, timestamp1);
        System.out.println("duration between timestamps: "+ duration1.getSeconds());

        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(timestamp1, ZoneId.systemDefault());
        System.out.println("local date time using zone id system default: "+localDateTime3);
    }

}
