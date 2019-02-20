package com.li.goodsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import com.li.goodsserver.model.GoodsImg;
import com.li.goodsserver.model.GoodsSku;
import com.li.goodsserver.mapper.GoodsSkuMapper;
import com.li.goodsserver.service.IGoodsSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
@Service
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuMapper, GoodsSku> implements IGoodsSkuService {

    @Override
    public List<GoodsSku> selectGoodsSkuByGoodsId(int goodsId) {
        QueryWrapper<GoodsSku> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(GoodsSku::getGoodsId,goodsId);
        return baseMapper.selectList(queryWrapper);
    }


    @Override
    public GoodsSku getById(Serializable id) {
        return super.getById(id);
    }

    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    @Override
    public boolean updateById(GoodsSku entity) {
        return super.updateById(entity);
    }
}
