package com.li.orderserver.service.impl;

import com.li.orderserver.model.OrderInfoDetail;
import com.li.orderserver.mapper.OrderInfoDetailMapper;
import com.li.orderserver.service.IOrderInfoDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单明细表 服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
@Service
public class OrderInfoDetailServiceImpl extends ServiceImpl<OrderInfoDetailMapper, OrderInfoDetail> implements IOrderInfoDetailService {

}
