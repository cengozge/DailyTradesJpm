package com.jpm.utils;

import com.jpm.enums.Currency;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    protected static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM uuuu");

    private DateUtil(){}

    public static String formatDate(LocalDate date) {
        return dateTimeFormatter.format(date);
    }

    public static boolean isDayInWorkDays(DayOfWeek dayOfWeek, Currency currency) {
        return Currency.getDaysOfWeek(currency).contains(dayOfWeek);
    }
}
