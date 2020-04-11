package com.dw.gfs.common.utils;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * 时间处理类
 * @author liaodewen
 */
public class DateUtils {

    /**
     * 获取当前时间
     * @return 当前时间
     */
    public static Date getNow() {
        return DateTime.now().toDate();
    }

}
