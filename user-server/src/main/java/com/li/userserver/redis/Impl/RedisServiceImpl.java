package com.li.userserver.redis.Impl;/**
 * @author lihaodong
 * @create 2018-12-01 15:32
 * @desc
 **/

import com.li.userserver.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lihaodong
 * @create 2018-12-01 15:32
 * @mail lihaodongmail@163.com
 * @desc
 **/
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean savePhoneCode(String phone, String securityCode, long timeout) {
        try {
            // 设置的是2分钟失效，1分钟之内查询有结果，1分钟之后返回为null或者空指针
            redisTemplate.opsForValue().set(phone, securityCode, timeout, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public String get(String key) {
        try {
            return redisTemplate.opsForValue().get(key).toString();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }

    }
}
