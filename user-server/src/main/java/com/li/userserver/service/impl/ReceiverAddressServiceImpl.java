package com.li.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.userserver.model.ReceiverAddress;
import com.li.userserver.mapper.ReceiverAddressMapper;
import com.li.userserver.service.IReceiverAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
@Service
public class ReceiverAddressServiceImpl extends ServiceImpl<ReceiverAddressMapper, ReceiverAddress> implements IReceiverAddressService {

    @Override
    public boolean save(ReceiverAddress entity) {
        entity.setAddress(entity.getProvince()+entity.getCity()+entity.getCounty()+entity.getAddressDetail());
        return super.save(entity);
    }

    @Override
    public boolean updateById(ReceiverAddress entity) {
        return super.updateById(entity);
    }

    @Override
    public IPage<ReceiverAddress> selectPageExt(int userId, int page, int pageSize) {
        Page<ReceiverAddress> goodsPage = new Page<>(page, pageSize);
        QueryWrapper<ReceiverAddress> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(ReceiverAddress::getId,ReceiverAddress::getName,ReceiverAddress::getTel,ReceiverAddress::getAddress)
                .eq(ReceiverAddress::getUserId,userId);
        return baseMapper.selectPage(goodsPage,queryWrapper);
    }
}
