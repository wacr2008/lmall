package com.li.orderserver.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Order
 * @Author lihaodong
 * @Date 2019/2/11 16:07
 * @Mail lihaodongmail@163.com
 * @Description
 * @Version 1.0
 **/

@Data
public class Order implements Serializable {


    private static final long serialVersionUID = -2221214252163879885L;

    private String orderId; // 订单id

    private Integer orderStatus; // 订单状态 0：未支付，1：已支付，2：订单已取消

    private String orderName; // 订单名字
}
