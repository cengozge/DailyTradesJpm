package com.jpm.com.jpm.utils;

import com.jpm.enums.Currency;
import com.jpm.utils.DateUtil;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static com.jpm.utils.DateUtil.formatDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilUnitTest {

    @Test
    public void formatDate_shouldFormatDate() throws Exception{
        LocalDate date = LocalDate.of(2017, 07, 05);
        assertEquals(formatDate(date), "05 Jul 2017");
    }

    @Test(expected = Exception.class)
    public void formatDate_shouldThrowExceptionWithNullDate() throws Exception{
        LocalDate date = null;
        formatDate(date);
    }

    @Test
    public void isDateInWorkDays_shouldReturnTrue(){
        assertTrue(DateUtil.isDayInWorkDays(DayOfWeek.MONDAY, Currency.AED));
    }

    @Test
    public void isDateInWorkDays_shouldReturnFalse(){
        assertFalse(DateUtil.isDayInWorkDays(DayOfWeek.SATURDAY, Currency.SGP));
    }

}