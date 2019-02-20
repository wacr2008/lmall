package com.li.goodsserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.goodsserver.model.Brand;
import com.li.goodsserver.model.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-07
 */
@Repository
public interface TypeMapper extends BaseMapper<Type> {

    @Override
    int insert(Type type);

    @Override
    int deleteById(Serializable serializable);

    List<Brand> selectListByWrapper(@Param("ew") Wrapper wrapper);
}
