package com.li.goodsserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
public interface BrandMapper extends BaseMapper<Brand> {

    @Override
    int insert(Brand brand);

    @Override
    List<Brand> selectList(@Param("ew") Wrapper<Brand> wrapper);

}
