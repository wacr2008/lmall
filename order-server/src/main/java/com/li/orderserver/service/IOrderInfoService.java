package com.li.orderserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.orderserver.model.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    @Override
    boolean save(OrderInfo orderInfo);

    /**
     * 订单状态查询
     * @param state
     * @param page
     * @param pageSize
     * @return
     */
    IPage<OrderInfo> selectPageByState(int userId,int state, int page, int pageSize);

    /**
     * 所有订单
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    IPage<OrderInfo> selectOrderInfoPage(int userId,int page, int pageSize);

    /**
     * 根据ID修改
     * @param orderInfo
     * @return
     */
    @Override
    boolean updateById(OrderInfo orderInfo);

    /**
     * 根据ID获取
     * @param serializable
     * @return
     */
    @Override
    OrderInfo getById(Serializable serializable);

    /**
     * 根据ID删除
     * @param serializable
     * @return
     */
    @Override
    boolean removeById(Serializable serializable);

    OrderInfo getOrderByOrderId(String orderId);
}
