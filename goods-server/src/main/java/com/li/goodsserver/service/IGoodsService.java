package com.li.goodsserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.goodsserver.model.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
public interface IGoodsService extends IService<Goods> {

    @Override
    boolean save(Goods goods);

    List<Goods> selectGoodsList(Wrapper<Goods> wrapper);

    @Override
    Goods getById(Serializable serializable);

    List<Goods> selectHotGoods();

    IPage<Goods> selectPageExt(Goods goods, int page, int pageSize);

    IPage<Goods> selectGoodsPageByBrandId(Goods goods, int page, int pageSize);

    Map<String,Object> selectGoodsByGoodsId(int goodsId);

    @Override
    boolean updateById(Goods goods);
}
