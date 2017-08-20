package com.jpm.services;

import com.jpm.enums.Currency;
import com.jpm.utils.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateOperation {

    public static LocalDate setDateToFirstWorkDay(LocalDate date, Currency currency){

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if(!DateUtil.isDayInWorkDays(dayOfWeek, currency)) {
            //setToFirstWorkDay
            if(currency == Currency.AED || currency == Currency.SAR) {
                if(dayOfWeek == DayOfWeek.SATURDAY) {
                    return date.plusDays(2);
                }
                else {
                    return date.plusDays(1);
                }
            }
            else {
                if(dayOfWeek == DayOfWeek.SUNDAY){
                    return date.plusDays(2);
                }
                else {
                    return date.plusDays(1);
                }
            }
        }
        return date;
    }


}
