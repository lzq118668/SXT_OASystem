package com.bjsxt.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
* 字符串格式的日期转换为日期格式
*
*@author leo
*/
public class DateUtil {

    /**
     * 输入一个日期的字符串，对其进行格式化为{@link Date}类型的日期格式作为返回
     *  参数返回。
    *
    *@author leo
    *@param s
    *@return {@link Date}
    */
    public static Date StrToDate(String s) {
        if (s != null && s!="") {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date date = df.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;

    }
}
