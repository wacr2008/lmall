package com.li.userserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.userserver.model.UserCollect;
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
 * @since 2019-01-21
 */
public interface UserCollectMapper extends BaseMapper<UserCollect> {

    @Override
    int insert(UserCollect userCollect);
    @Override
    int deleteById(Serializable serializable);
    @Override
    int delete(@Param("ew") Wrapper<UserCollect> wrapper);

    @Override
    UserCollect selectOne(@Param("ew") Wrapper<UserCollect> wrapper);

    @Override
    IPage<UserCollect> selectPage(IPage<UserCollect> iPage,@Param("ew") Wrapper<UserCollect> wrapper);
}
