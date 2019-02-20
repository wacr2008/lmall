package com.li.messageserver.utils;/**
 * @author lihaodong
 * @create 2018-11-22 22:15
 * @desc
 **/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**

 * @author lihaodong
 * @create 2018-11-22 22:15
 * @mail lihaodongmail@163.cn
 * @desc
 **/

public class TimeUtil {

    //获得当前时间
    public static String genCurrentTimeStamp() {
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = sdf.format(currentDate);
        return timeStamp;
    }
}
