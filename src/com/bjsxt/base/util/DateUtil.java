package com.bjsxt.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

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
