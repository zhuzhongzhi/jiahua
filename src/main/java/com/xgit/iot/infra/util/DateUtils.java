package com.xgit.iot.infra.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by liyuan on 2017/5/9.
 */
public class DateUtils {
    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }

    public static Date getYestday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date getLastMonthDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }

    public static long getCurrentHourSecond() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);

        now.set(year, month, day, hour, 0, 0);
        return now.getTimeInMillis() / 1000;
    }

    public static Integer getYear() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        return year;
    }

    public static Integer getMonth() {
        Calendar now = Calendar.getInstance();
        int month = now.get(Calendar.MONTH) + 1;
        return month;
    }

    public static Integer getDay() {
        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    public static long getCurrentDayMinute() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        int day = now.get(Calendar.DAY_OF_MONTH);

        now.set(year, month, day, 0, 0, 0);
        return now.getTimeInMillis() / 1000 / 60;
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0) {
            return "00:00";
        }
        minute = time / 60;
        if (minute < 60) {
            second = time % 60;
            timeStr = unitFormat(minute) + ":" + unitFormat(second);
            return timeStr;
        }
        hour = minute / 60;
        if (hour > 99) {
            return "99:59:59";
        }
        minute = minute % 60;
        second = time - hour * 3600 - minute * 60;
        timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        } else {
            retStr = "" + i;
        }
        return retStr;
    }

    /**
     * Date转String <br>
     * 根据format格式转换时间为字符串
     *
     * @param date   时刻
     * @param format 转换模板
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            date = new Date();
        }

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String retTime = formatter.format(date);

        return retTime;
    }

    /**
     * 获取当前时间 <功能详细描述>
     *
     * @param format 时间格式
     * @return String format格式
     * @see [类、类#方法、类#成员]
     */
    public static String getCurrentTime(String format) {
        return dateToString(new Date(), format);
    }

    /**
     * 获取当前日期和时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取某天零点的函数
     *
     * @param date
     * @return
     */
    public static Date getStartTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 0); // 24小时制
        day.set(Calendar.MINUTE, 0);
        day.set(Calendar.SECOND, 0);
//        day.set(Calendar.MILLISECOND, 0);
        return day.getTime();
    }

    /**
     * 获取某天末点的函数
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        day.set(Calendar.HOUR_OF_DAY, 23); // 24小时制
        day.set(Calendar.MINUTE, 59);
        day.set(Calendar.SECOND, 59);
//        day.set(Calendar.MILLISECOND, 999);
        return day.getTime();
    }

    /**
     * 获取某天所在周第一天
     *
     * @return
     */
    public static Date getWeekStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取某天所在周最后一天
     *
     * @return
     */
    public static Date getWeekEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获取某天所在月第一天
     *
     * @return
     */
    public static Date getMonthStartDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取某天所在月最后一天
     *
     * @return
     */
    public static Date getMonthEndDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 根据天数修改日期
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date adjustDay(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, offset);
        Date newDate = calendar.getTime();
        return newDate;
    }

    /**
     * 根据秒数增加日期
     *
     * @param date
     * @param sec
     * @return
     */
    public static Date addBySec(Date date, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, sec);
        return calendar.getTime();
    }

    public static Date stringToDate(String source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 获取当前时间毫秒数
     *
     * @return
     */
    public static Long getCurrentMillisecond() {
        return getCurrentDate().getTime();
    }

    /**
     * 固定格式date1在date2之前
     *
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static boolean dateBeforeByFomat(Date date1, Date date2, String format) {
        String str1 = dateToString(date1, format);
        String str2 = dateToString(date2, format);
        Date newDate1 = stringToDate(str1, format);
        Date newDate2 = stringToDate(str2, format);
        if (newDate1.before(newDate2)) {
            return true;
        }
        return false;
    }

    /**
     * 固定格式date1在date2之后
     *
     * @param date1
     * @param date2
     * @param format
     * @return
     */
    public static boolean dateAfterByFomat(Date date1, Date date2, String format) {
        String str1 = dateToString(date1, format);
        String str2 = dateToString(date2, format);
        Date newDate1 = stringToDate(str1, format);
        Date newDate2 = stringToDate(str2, format);
        if (newDate1.after(newDate2)) {
            return true;
        }
        return false;
    }

    /**
     * 获取某段时间内的所有日期
     *
     * @return
     */
    public static List<Date> findDates(Date beginDate, Date endDate, int calenderType) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(beginDate);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(beginDate);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(endDate);
        // 测试此日期是否在指定日期之后
        while (calEnd.after(calBegin)) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(calenderType, 1);
            if (calEnd.after(calBegin)) {
                dateList.add(calBegin.getTime());
            }
        }
        return dateList;
    }

    /**
     * 根据传进来的时间戳 获取对应的时间格式
     *
     * @param format 时间格式
     * @param stamp  时间戳
     * @return
     */
    public static String getTimeStampFormat(String format, Long stamp) {
        if (stamp == null) {
            return null;
        }
        if (format == null) {
            format = "yyyy-MM-dd HH:mm:ss/SSS";
        }
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(stamp);
    }

    /**
     * 根据传入的时间获取时间差
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String getDuration(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            return StringUtils.EMPTY;
        }
        long between = endDate.getTime() - beginDate.getTime();
        String duration = getDuration(between);
        return duration;
    }

    public static String getDuration(long between) {
        if (between <= 0) {
            return StringUtils.EMPTY;
        }

        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String duration = StringUtils.EMPTY;
        if (day > 0) {
            duration += day + "天";
        }
        if (hour > 0) {
            duration += hour + "小时";
        }
        if (min > 0) {
            duration += min + "分";
        }
        if (s > 0) {
            duration += s + "秒";
        }
        return duration;
    }

    /**
     * 获取两个日期之间的所有日期
     *
     * @param startTime 开始日期
     * @param endTime   结束日期
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            // 日期加1(包含结束)
            tempEnd.add(Calendar.DATE, +1);
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return days;
    }

    /**
     * 获取两个日期之间的所有月份
     *
     * @param startTime 开始日期
     * @param endTime   结束日期
     * @return
     */
    public static List<String> getMonths(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        try {
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(startTime));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(endTime));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * endDay 比 startDay 多的天数
     *
     * @param startDay
     * @param endDay
     * @return
     */
    public static int differentDays(Date startDay, Date endDay) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startDay);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDay);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            return day2 - day1;
        }
    }

    /**
     * 获取某个月的天数
     *
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
