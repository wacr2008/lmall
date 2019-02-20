package com.li.cartserver.redis;


import java.util.Date;

/**
 * @Author lihaodong
 * @Description
 * @Date 11:50 2019/1/15
 * @Param 
 * @return 
 **/
public interface RedisService {


    String getOrderIdPrefix(Date date);

    Long shopCartId(String prefix);
}
