package com.li.goodsserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.goodsserver.model.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    @Override
    int insert(Goods goods);

    @Override
    List<Goods> selectList(@Param("ew") Wrapper<Goods> wrapper);

    @Override
    Goods selectById(Serializable serializable);

    List<Goods> selectHotGoods();

    @Override
    IPage<Goods> selectPage(IPage<Goods> iPage,@Param("ew") Wrapper<Goods> wrapper);

    @Override
    int updateById(Goods goods);
}
