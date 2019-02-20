package com.li.orderserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.orderserver.model.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    @Override
    int insert(OrderInfo orderInfo);

    @Override
    IPage<OrderInfo> selectPage(IPage<OrderInfo> iPage,@Param("ew") Wrapper<OrderInfo> wrapper);

    @Override
    OrderInfo selectById(Serializable serializable);

    @Override
    int updateById(@Param("et") OrderInfo orderInfo);

    @Override
    int deleteById(Serializable serializable);

    @Override
    OrderInfo selectOne(Wrapper<OrderInfo> wrapper);
}
