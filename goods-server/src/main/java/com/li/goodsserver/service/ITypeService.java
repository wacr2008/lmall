package com.li.goodsserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.li.goodsserver.model.Type;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-07
 */
public interface ITypeService extends IService<Type> {

    @Override
    boolean save(Type type);

    @Override
    boolean removeById(Serializable serializable);

    @Override
    List<Type> list(Wrapper<Type> wrapper);

}
