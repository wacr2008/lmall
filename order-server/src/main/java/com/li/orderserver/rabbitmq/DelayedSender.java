package com.li.orderserver.rabbitmq;

import com.li.orderserver.model.Order;
import com.li.orderserver.model.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DelayedSender
 * @Author lihaodong
 * @Date 2019/2/11 14:29
 * @Mail lihaodongmail@163.com
 * @Description
 * @Version 1.0
 **/
@Slf4j
@Component
public class DelayedSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDelay(OrderInfo orderInfo) {
        log.info("【订单生成时间】" + new Date().toString() + "【15分钟后检查订单是否已经支付】" + orderInfo.toString());
        rabbitTemplate.convertAndSend(DelayRabbitConfig.ORDER_DELAY_EXCHANGE, DelayRabbitConfig.ORDER_DELAY_ROUTING_KEY, orderInfo, message -> {
            // 如果配置了 params.put("x-message-ttl", 5 * 1000)
            // 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(15 * 1000 * 60 + "");
            return message;
        });
    }
}
