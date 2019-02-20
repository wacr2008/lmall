package com.li.userserver.redis;


/**
 * @Author lihaodong
 * @Description
 * @Date 11:50 2019/1/15
 * @Param 
 * @return 
 **/
public interface RedisService {

    // 保存用户手机验证码
    boolean savePhoneCode(String phone, String securityCode, long timeout);
    // 通用 通过key获取value
    String get(String key);
}
