package com.li.goodsserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.Slideshow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
public interface SlideshowMapper extends BaseMapper<Slideshow> {

    @Override
    int insert(Slideshow slideshow);

    @Override
    List<Slideshow> selectList(@Param("ew") Wrapper<Slideshow> wrapper);
}
