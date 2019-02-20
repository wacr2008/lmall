package com.li.cartserver.redis.Impl;

import com.li.cartserver.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author lihaodong
 * @Description
 * @Param 
 * @return 
 **/
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String getOrderIdPrefix(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        //补两位,因为一年最多三位数
        String monthFormat = String.format("%1$02d", month+1);
        //补两位，因为日最多两位数
        String dayFormat = String.format("%1$02d", day);
        //补两位，因为小时最多两位数
        String hourFormat = String.format("%1$02d", hour);
        return year + monthFormat + dayFormat+hourFormat;
    }

    @Override
    public Long shopCartId(String prefix) {
        String key = "SHOP_CART_ID_" + prefix;
        String orderId = null;
        try {
            Long increment = redisTemplate.opsForValue().increment(key,1);
            //往前补6位
            orderId=prefix+String.format("%1$06d",increment);
        } catch (Exception e) {
            log.error("生成订单号失败,{}",e.getMessage());
            e.printStackTrace();
        }
        return Long.valueOf(orderId);
    }

}