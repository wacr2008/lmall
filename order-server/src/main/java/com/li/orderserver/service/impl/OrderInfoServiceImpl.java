package com.li.orderserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.orderserver.model.OrderInfo;
import com.li.orderserver.mapper.OrderInfoMapper;
import com.li.orderserver.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Override
    public boolean save(OrderInfo entity) {
        return super.save(entity);
    }

    @Override
    public IPage<OrderInfo> selectPageByState(int userId,int state, int page, int pageSize) {
        Page<OrderInfo> orderInfoPage = new Page<>(page, pageSize);
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(OrderInfo::getState,state)
                .eq(OrderInfo::getUserId,userId);
        return baseMapper.selectPage(orderInfoPage,queryWrapper);
    }

    @Override
    public IPage<OrderInfo> selectOrderInfoPage(int userId,int page, int pageSize) {
        Page<OrderInfo> orderInfoPage = new Page<>(page, pageSize);
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(OrderInfo::getUserId,userId);
        queryWrapper.lambda().select(OrderInfo::getGoodsId);
        return baseMapper.selectPage(orderInfoPage,queryWrapper);
    }

    @Override
    public boolean updateById(OrderInfo entity) {
        return super.updateById(entity);
    }

    @Override
    public OrderInfo getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public OrderInfo getOrderByOrderId(String orderId) {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(OrderInfo::getOrderId,orderId);
        return baseMapper.selectOne(queryWrapper);
    }
}

