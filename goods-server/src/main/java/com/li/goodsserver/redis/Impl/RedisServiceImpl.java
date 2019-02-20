package com.li.goodsserver.redis.Impl;

import com.li.goodsserver.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author lihaodong
 * @Description
 * @Date 11:46 2019/1/9
 * @Param
 * @return
 **/
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean save(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e){
            log.error("redis存放字符串失败:{}",e.getMessage());
            return false;
        }
    }

    @Override
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean removeKey(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Object getBrandList(String h, String k) {
        return redisTemplate.opsForHash().get(h,k);
    }
}
