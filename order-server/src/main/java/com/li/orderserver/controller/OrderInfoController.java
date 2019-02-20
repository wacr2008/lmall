package com.li.orderserver.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.orderserver.bo.RestResponseBo;
import com.li.orderserver.model.Order;
import com.li.orderserver.model.OrderInfo;
import com.li.orderserver.rabbitmq.DelayedSender;
import com.li.orderserver.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
@RestController
@RequestMapping("/order-info")
public class OrderInfoController {

    @Autowired
    private DelayedSender delaySender;

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private DelayedSender sender;

    /**
     * 待付款时创建订单
     *
     * @param orderInfo
     * @param request
     */
    @PostMapping("/createOrder")
    public void createOrder(OrderInfo orderInfo, HttpServletRequest request) {
        int userId = (int) request.getSession().getAttribute("userId");
        orderInfo.setUserId(userId);
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        orderInfo.setCreateTime(localDateTime);
        orderInfoService.save(orderInfo);
        // 商品库存也要进行锁定

        // 进入延迟队列
        sender.sendDelay(orderInfo);
    }


    /**
     * 订单状态查询
     *
     * @param state
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectOrderInfoByState")
    public RestResponseBo selectOrderInfoByState(int state, int page, int pageSize, HttpServletRequest request) {
        int userId = (int) request.getSession().getAttribute("userId");
        IPage<OrderInfo> orderInfoIPage = null;
        if (state == 0) {
            orderInfoIPage = orderInfoService.selectOrderInfoPage(userId, page, pageSize);
        } else {
            orderInfoIPage = orderInfoService.selectPageByState(userId, state, page, pageSize);
        }
        List<OrderInfo> orderInfoList = orderInfoIPage.getRecords();
        long pages = orderInfoIPage.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("orderInfoList", orderInfoList);
        map.put("pages", pages);
        return RestResponseBo.ok(map, 000);
    }

    /**
     * 根据订单id修改订单
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateOrder")
    public RestResponseBo update(int id,int state) {
        OrderInfo orderInfo = orderInfoService.getById(id);
        // 6 已关闭订单
        orderInfo.setState(state);
        orderInfoService.updateById(orderInfo);
        return RestResponseBo.ok();
    }

    /**
     * 根据订单号修改状态
     * @param orderId
     * @param state
     * @return
     */
    @RequestMapping("/updateOrderState")
    public RestResponseBo updateOrderByOrderId(String orderId,int state){
        OrderInfo orderInfo = orderInfoService.getOrderByOrderId(orderId);
        orderInfo.setState(state);
        return RestResponseBo.ok();
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteOrder")
    public RestResponseBo deleteOrder(int id) {
        orderInfoService.removeById(id);
        return RestResponseBo.ok();
    }

    /**
     * 根据id查询订单
     *
     * @param id
     * @return
     */
    @RequestMapping("/selectOrderInfoById")
    public RestResponseBo selectOrderInfoById(int id) {
        OrderInfo orderInfo = orderInfoService.getById(id);
        return RestResponseBo.ok(orderInfo, 000);
    }

    /**
     * 根据订单号id查询订单
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/selectOrderInfoByOrderId")
    public RestResponseBo selectOrderInfoByOrderId(String orderId) {
        OrderInfo orderInfo = orderInfoService.getById(orderId);
        return RestResponseBo.ok(orderInfo, 000);
    }




}

