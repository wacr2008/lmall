package com.li.userserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.userserver.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
public interface UserMapper extends BaseMapper<User> {

    @Override
    int insert(User user);

    @Override
    List<User> selectList(@Param("ew") Wrapper<User> wrapper);
}
