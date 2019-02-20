package com.li.goodsserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.Goods;
import com.li.goodsserver.model.GoodsImg;
import com.li.goodsserver.model.GoodsSku;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
public interface IGoodsSkuService extends IService<GoodsSku> {

    List<GoodsSku> selectGoodsSkuByGoodsId(int goodsId);

    @Override
    GoodsSku getById(Serializable serializable);


    @Override
    boolean updateById(GoodsSku goodsSku);
}
