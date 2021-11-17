package com.tq.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //1.字符串转换为util.Date
        public static java.util.Date strToUtil(String str){
            try {
                java.util.Date date = sdf.parse(str);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
        //2.util.Date转换为字符串
        public static String DatetoStr(java.util.Date date){
            return sdf.format(date);
        }
        //3.util.Date转换为sql.Date
        public static java.sql.Date UtiltoSql(java.util.Date date){
            return new java.sql.Date(date.getTime());
        }

}
