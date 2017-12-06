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
        System.out.println("������:" + format.format(today));

        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 30);// ����+1��

        Date returnTime = c.getTime();
        return returnTime;
    }
}
