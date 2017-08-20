package com.jpm.enums;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Currency {

    SGP("SGP"), AED("AED"), SAR("SAR");

    public String currency;

    Currency(String currency){
        this.currency = currency;
    }

    public static Currency getRandomCurrency(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public static List<DayOfWeek> getDaysOfWeek(Currency currency){
        List<DayOfWeek> daysOfWeek = new ArrayList<>();
        if(currency == Currency.SAR || currency == Currency.AED){
            daysOfWeek.add(DayOfWeek.MONDAY);
            daysOfWeek.add(DayOfWeek.TUESDAY);
            daysOfWeek.add(DayOfWeek.WEDNESDAY);
            daysOfWeek.add(DayOfWeek.THURSDAY);
            daysOfWeek.add(DayOfWeek.FRIDAY);
        }
        else {
            daysOfWeek.add(DayOfWeek.SUNDAY);
            daysOfWeek.add(DayOfWeek.MONDAY);
            daysOfWeek.add(DayOfWeek.TUESDAY);
            daysOfWeek.add(DayOfWeek.WEDNESDAY);
            daysOfWeek.add(DayOfWeek.THURSDAY);
        }
        return daysOfWeek;
    }
 }
