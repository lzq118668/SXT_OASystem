package com.bjsxt.base.util;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 字符串格式的日期转换为日期格式
 *
 * @author leo
 */
public class DateUtil {

    /**
     * 输入一个日期的字符串，对其进行格式化为{@link Date}类型的日期格式作为返回
     * 参数返回。
     *
     * @param s
     * @return {@link Date}
     * @author leo
     */
    public static Date StrToDate(String s) {
        if (s != null && s != "") {
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

    /**
     * 比较两个时间的先后
     *
     * @param time1
     * @param time2
     * @return boolean
     * @author leo
     */
    public static boolean compareTime(String time1, String time2) throws ParseException {
        //如果想比较日期则写成"yyyy-MM-dd"就可以了
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        //将字符串形式的时间转化为Date类型的时间
        Date a = sdf.parse(time1);
        Date b = sdf.parse(time2);
        //Date类的一个方法，如果a早于b返回true，否则返回false
        if (a.before(b))
            return true;
        else
            return false;

    }

    /**
    * 定时器最后一次签退与当天的11：30进行计算毫秒值，时间到后然后销毁session
    *
    *@author leo
    *@param nowtime
    *@param session
    *@return
    */
    public static void TimeForSession(String nowtime, HttpSession session) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        //将字符串形式的时间转化为Date类型的时间
        Date a = sdf.parse(nowtime);
        Date b = sdf.parse("11:30:00");

        new Timer().schedule(new TimerTask() {

        @Override
        public void run() {
            session.invalidate();

        }
    }, b.getTime() - a.getTime());
}
}
