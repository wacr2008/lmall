package com.li.goodsserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.GoodsSku;
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
 * @since 2019-01-12
 */
public interface GoodsSkuMapper extends BaseMapper<GoodsSku> {

    @Override
    List<GoodsSku> selectList(@Param("ew") Wrapper<GoodsSku> wrapper);

    @Override
    GoodsSku selectById(Serializable serializable);

    @Override
    GoodsSku selectOne(@Param("ew") Wrapper<GoodsSku> wrapper);

    @Override
    int updateById(@Param("et") GoodsSku goodsSku);
}
