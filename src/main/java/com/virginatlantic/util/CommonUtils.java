package com.virginatlantic.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CommonUtils {
    /*
    *Getting the day of week for a given date
    * @param in
    * @return day of the week
    * */
    public static String getWeekDay(String in){
        String year=in.substring(0,4);
        String month=in.substring(5,7);
        String day=in.substring(8,10);
        LocalDate localDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }
    /*
    * validates the passed input date is in the format "yyyy-MM-dd"
    * @param date
    */
    public static void validateDate(String date) throws Exception {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            Date validate= formatter.parse(date);
        } catch (Exception e) {
            throw e;
        }
    }
}
