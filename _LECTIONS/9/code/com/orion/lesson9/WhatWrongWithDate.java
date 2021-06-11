package com.orion.lesson9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.crypto.Data;

public class WhatWrongWithDate {


    public static void main(String[] args) {

        LocalDate fivthSeptember = LocalDate.of(2020, Month.FEBRUARY, 5);

        final LocalDate plusTwoMonth = fivthSeptember.plus(2, ChronoUnit.MONTHS);


        final LocalDate localDate = fivthSeptember.withDayOfMonth(15);


        final LocalDate with = fivthSeptember.with(TemporalAdjusters.lastDayOfMonth());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Дата: yyyy-MM-dd HH:mm");


        final TemporalAccessor parse = formatter.parse("Дата: 2020-02-28 12:22");
        System.out.println(LocalDateTime.from(parse));

        System.out.println(formatter.format(LocalDateTime.now()));


        Period period = Period.between(LocalDate.now(), LocalDate
                .now()
                .plusMonths(1)
                .with(TemporalAdjusters.lastDayOfMonth()));


        final long between = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate
                .now()
                .plusMonths(1)
                .with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(period.getDays());

        System.out.println(between);


        final ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Ho_Chi_Minh")));


        System.out.println(zonedDateTime.withZoneSameLocal(ZoneId.of("Asia/Ho_Chi_Minh")));




    }
}
