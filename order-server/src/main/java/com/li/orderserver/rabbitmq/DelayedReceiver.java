package com.li.orderserver.rabbitmq;

import com.li.orderserver.model.OrderInfo;
import com.li.orderserver.service.IOrderInfoService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName DelayedReceiver
 * @Author lihaodong
 * @Date 2019/2/11 14:30
 * @Mail lihaodongmail@163.com
 * @Description
 * @Version 1.0
 **/
@Slf4j
@Component
public class DelayedReceiver {

    @Autowired
    private IOrderInfoService orderInfoService;

    /**
     * 未付款时接收订单号进行查询 如果未付款则关闭订单
     * @param orderInfo
     * @param message
     * @param channel
     */
    @RabbitListener(queues = {DelayRabbitConfig.ORDER_QUEUE_NAME})
    public void orderDelayQueue(OrderInfo orderInfo, Message message, Channel channel) {
        log.info("【orderDelayQueue 监听的消息】 - 【消费时间】 - [{}]- 【订单内容】 - [{}]",  new Date(), orderInfo.toString());
        // 状态 1 为未付款 6 为关闭订单
        if(orderInfo.getState() == 1) {
            log.info("【该订单未支付，取消订单】" + orderInfo.toString());
            orderInfo.setState(6);
            orderInfoService.updateById(orderInfo);
        } else if(orderInfo.getState() == 2) {
            log.info("【该订单已完成支付】");
        } else if(orderInfo.getState() == 6) {
            log.info("【该订单已取消】");
        }
    }
}
