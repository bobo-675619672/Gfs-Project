package com.dw.gfs.common.utils;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * 时间处理类
 *
 * @author liaodewen
 */
public class DateUtil {

    public static final String FORMAT_Y = "yyyy";
    public static final String FORMAT_M = "MM";
    public static final String FORMAT_D = "dd";
    public static final String FORMAT_YM = "yyyy-MM";
    public static final String FORMAT_YMD = "yyyy-MM-dd";
    public static final String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    public static final int TIME_MILLISECOND = 0;
    public static final int TIME_SECOND = 1;
    public static final int TIME_MINUTE = 2;
    public static final int TIME_HOUR = 3;
    public static final int TIME_DAY = 4;
    public static final int TIME_MONTH = 5;
    public static final int TIME_YEAR = 6;

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Date getNow() {
        return DateTime.now().toDate();
    }

    /**
     * 获取当前间隔时间
     * @param intervalType 间隔类型
     * @param interval     间隔数
     * @return
     */
    public static Date getNowIntervalDate(int intervalType, int interval) {
        return getIntervalDate(getNow(), intervalType, interval);
    }

    /**
     * 获取间隔时间
     * @param date         时间
     * @param intervalType 间隔类型
     * @param interval     间隔数
     * @return
     */
    public static Date getIntervalDate(Date date, int intervalType, int interval) {
        DateTime dateTime = new DateTime(date);
        if (TIME_MILLISECOND == intervalType) { // 毫秒
            dateTime = dateTime.plusMillis(interval);
        } else if (TIME_SECOND == intervalType) { // 秒
            dateTime = dateTime.plusSeconds(interval);
        } else if (TIME_MINUTE == intervalType) { // 分钟
            dateTime = dateTime.plusMinutes(interval);
        } else if (TIME_HOUR == intervalType) { // 小时
            dateTime = dateTime.plusHours(interval);
        } else if (TIME_DAY == intervalType) { // 天
            dateTime = dateTime.plusDays(interval);
        } else if (TIME_MONTH == intervalType) { // 月
            dateTime = dateTime.plusMonths(interval);
        } else if (TIME_YEAR == intervalType) { // 年
            dateTime = dateTime.plusYears(interval);
        }
        return dateTime.toDate();
    }

}
