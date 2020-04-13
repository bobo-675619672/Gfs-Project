package com.dw.gfs.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String工具类
 * @author liaodewen
 */
public class StringUtil {

    public final static String REGEX = "^[1-9]+(,[1-9]+)*$";

    /**
     * 反转字符串
     *
     * @param str       需要进行反转的字符串
     * @param separator 分隔符
     * @return
     */
    public static String reversal(String str, String separator) {
        StringBuffer reversal = new StringBuffer();
        String[] strs = str.split(separator);
        for (int index = strs.length - 1; index >= 0; index--) {
            if (index == 0) {
                reversal.append(strs[index]);
            } else {
                reversal.append(strs[index] + "/");
            }
        }
        return reversal.toString();
    }

    /**
     * 计算某个字符串中某个字符的个数
     * @param parent
     * @param subs
     * @return
     */
    public static int countStrSubs(String parent , String subs){
        int fromIndex = 0;
        int count = 0;
        while(true){
            int index = parent.indexOf(subs, fromIndex);
            if(-1 != index){
                fromIndex = index + 1;
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    /**
     * 字符串转数组
     *
     * @param str       需转化的字符串
     * @param separator 分割符
     * @return
     */
    public static String[] getStrs(String str, String separator) {
        String[] strs = str.split(separator);
        return strs;
    }

    /**
     * 格式化 错误码
     *
     * @param errorMsg
     * @param params
     * @return
     */
    public static String format(String errorMsg, String... params) {
        if (params != null && params.length > 0) {
            errorMsg = String.format(errorMsg, params);
            return errorMsg;
        }
        return errorMsg;
    }


    /**
     * 效验手机号码
     *
     * @return
     */
    public static String lineFeed(String str) {
        String reqEx = "\\s*|\t|\r|\n";
        Pattern localPattern = Pattern.compile(reqEx);
        Matcher m = localPattern.matcher(str);
        str = m.replaceAll("");
        return str;
    }

    /**
     *  string to list
     * @param content
     * @return
     */
    public static List<String> stringList(String content) {
        String[] str = content.split(",");
        List<String> list = Arrays.asList(str);
        return list;
    }

    /**
     * 占位符
     *
     * @param content
     * @param keys
     * @param values
     * @return content
     * @author liweicheng
     */
    public static String placeholder(String content, String[] keys, String[] values) {
        String regEx = "@\\w+@";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(content);
        Map<String, String> keymaps = new HashMap<>(16);
        while (matcher.find()) {
            keymaps.put(matcher.group(), null);
        }
        List<String> keyList = new ArrayList<>(Arrays.asList(keys));
        List<String> valueList = new ArrayList<>(Arrays.asList(values));
        for (int i = 0; i < keyList.size(); i++) {
            if (keymaps.keySet().contains(keyList.get(i))) {
                keymaps.put(keyList.get(i), valueList.get(i));
            }
        }
        for (Map.Entry patt : keymaps.entrySet()) {
            content = content.replaceAll(patt.getKey().toString(), patt.getValue().toString());
        }
        return content;
    }

    /**
     * 根据时间字符串转换毫秒数
     * @param strTime
     * @return
     */
    public static int getMsec(String strTime) {
        String[] arrAll = strTime.split(":");
        //分
        int minute = Integer.parseInt(arrAll[1].trim());
        String[] secAll = arrAll[2].trim().split("\\.");
        //秒
        int sec = Integer.parseInt(secAll[0].trim());
        //毫秒
        int msec = Integer.parseInt(secAll[1].trim());
        int res = (minute * 60 + sec) * 1000 + msec;
        return res;
        //00：01：10.111 = (1 X 60+10+) X 1000 +111 = 70111
//        int minute = time.Minute;
//        int sec = time.Second;
//        int msec = time.Millisecond;
//        int res = (minute * 60 + sec) * 1000 + msec;
//        return res;
    }

    public static boolean isEmpty(CharSequence str) {
        return StringUtils.isEmpty(str);
    }

}
