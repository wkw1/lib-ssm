package com.wkw.unit;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * create by wkw
 */
public class ReturnTime {

    public static Date getReturnTime(){
        Format format = new SimpleDateFormat("yyyy-MM-dd");

        Date today = new Date();
        System.out.println("今天是:" + format.format(today));

        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 30);// 今天+1天

        Date returnTime = c.getTime();
        return returnTime;
    }
}
