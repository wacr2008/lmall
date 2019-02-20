package com.li.cartserver.test;

import com.li.cartserver.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ClassName ShopCartTest
 * @Author lihaodong
 * @Date 2019/1/8 14:50
 * @Mail lihaodongmail@163.com
 * @Description 商品测试
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShopCartTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void contextLoads() {
        long startMillis = System.currentTimeMillis();
        String orderIdPrefix = redisService.getOrderIdPrefix(new Date());
        for (int i = 0; i < 10; i++) {
            Long aLong = redisService.shopCartId(orderIdPrefix);
            System.out.println(aLong);
        }
        long endMillis = System.currentTimeMillis();
        System.out.println("生成速度:"+(endMillis-startMillis)+",单位毫秒");
    }


}
