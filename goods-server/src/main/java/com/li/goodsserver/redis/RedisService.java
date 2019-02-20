package com.li.goodsserver.redis;


/**

 * @author lihaodong
 * @create 2018-12-01 15:27
 * @mail lihaodongmail@163.com
 * @desc
 **/
public interface RedisService {

    /**
     * @Author lihaodong
     * @Description
     * @Date 13:59 2019/1/9
     * @Param [key, value]
     * @return boolean
     **/
    boolean save(String key,Object value);

    Object getValue(String key);

    boolean removeKey(String key);

    Object getBrandList(String h,String k);



}
