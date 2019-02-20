package com.li.goodsserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.GoodsImg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
public interface GoodsImgMapper extends BaseMapper<GoodsImg> {

    @Override
    List<GoodsImg> selectList(@Param("ew") Wrapper<GoodsImg> wrapper);
}
