package com.li.orderserver.test;

import com.li.orderserver.model.Order;
import com.li.orderserver.rabbitmq.DelayedSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @ClassName DelayedTest
 * @Author lihaodong
 * @Date 2019/2/11 14:30
 * @Mail lihaodongmail@163.com
 * @Description
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class DelayedTest {

    @Autowired
    private DelayedSender sender;

    @Test
    public void sendDelay() {
        Order order1 = new Order();
        order1.setOrderStatus(0);
        order1.setOrderId("123456");
        order1.setOrderName("小米6");

        Order order2 = new Order();
        order2.setOrderStatus(1);
        order2.setOrderId("456789");
        order2.setOrderName("小米8");

        System.out.println("ok");
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Calendar now=Calendar.getInstance();
        now.add(Calendar.MINUTE,30);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.getTimeInMillis());
        String dateStr=sdf.format(now.getTimeInMillis());
        System.out.println(dateStr);
    }
}
