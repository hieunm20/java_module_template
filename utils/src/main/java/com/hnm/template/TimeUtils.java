package com.hnm.template;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 12/1/2022.
 */
public class TimeUtils {

    public static final long TIME_SECOND = 1000;
    public static final long TIME_MINUTE = 60 * TIME_SECOND;
    public static final long TIME_HOUR = 60 * TIME_MINUTE;
    public static final long TIME_DAY = 24 * TIME_HOUR;
    public static final long TIME_WEEK = 7 * TIME_DAY;

    public static final SimpleDateFormat SDF_1 = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat SDF_2 = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat SDF_3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static long now() {
        return System.currentTimeMillis();
    }

    public static Calendar resetHour(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal;
    }

    public static long addWeek(long time, int numberOfWeekAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.WEEK_OF_YEAR, numberOfWeekAdd);
        return cal.getTimeInMillis();
    }

    public static long addDay(long time, int numberOfDayAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.DAY_OF_YEAR, numberOfDayAdd);
        return cal.getTimeInMillis();
    }

    public static long addHour(long time, int numberOfHourAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.HOUR_OF_DAY, numberOfHourAdd);
        return cal.getTimeInMillis();
    }

    public static long addSecond(long time, int numberOfSecondAdd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(time));
        cal.add(Calendar.SECOND, numberOfSecondAdd);
        return cal.getTimeInMillis();
    }

    public static long getStartTimeOfDay() {
        Calendar cal = resetHour(new Date().getTime());
        return cal.getTimeInMillis();
    }

    public static long getStartTimeOfCurrentWeek() {
        Calendar cal = resetHour(new Date().getTime());
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTimeInMillis();
    }

    public static long getStartTimeOfWeek(long time) {
        Calendar cal = resetHour(time);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTimeInMillis();
    }

    public static long getStartTimeOfCurrentMonth() {
        Calendar cal = resetHour(new Date().getTime());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTimeInMillis();
    }

    public static long getEndTimeOfDay() {
        long time = addDay(now(), 1);
        Calendar cal = resetHour(time);
        cal.add(Calendar.SECOND, -1);
        return cal.getTimeInMillis();
    }

    public static long getEndTimeOfCurrentWeek() {
        long time = addWeek(now(), 1);
        long startTimeOfNextWeek = getStartTimeOfWeek(time);
        return addSecond(startTimeOfNextWeek, -1);
    }

    public static long getEndTimeOfCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getEndTimeOfDay());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTimeInMillis();
    }


    public static int weekOfYear(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int dayOfWeek(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int dayOfMonth(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        System.out.println(dayOfWeek(now()));
        long time = weekOfYear(now());
        String timeStr = SDF_3.format(new Date(time));
        System.out.println(timeStr);
    }

}
