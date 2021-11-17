package com.tq.person;

import java.text.SimpleDateFormat;

public class TestTimes {
    public static void main(String[] args)throws Exception{
        //获取当前系统时间
        System.out.println(new java.util.Date());

        //字符串：自定义日期
        String str = "1999-09-09";

        /*
         * SimpleDateFormat的parse和format方法
         */
        //String转成Util.Date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = simpleDateFormat.parse(str);
        System.out.println(date);

        //Util.Date转成String
        String dates = simpleDateFormat.format(new java.util.Date());
        System.out.println(dates);

        //sql.Date不支持字符串转换 只支持毫秒创建
        //通过util.Date拿到指定日期的毫秒值转换为sql.Date
        //sql.Date是util.Date的子类
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

        //获得毫秒值
        System.out.println(date.getTime());
    }
}
