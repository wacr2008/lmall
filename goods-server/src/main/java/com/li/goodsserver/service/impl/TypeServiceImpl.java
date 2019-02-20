package com.li.goodsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.goodsserver.mapper.TypeMapper;
import com.li.goodsserver.model.Type;
import com.li.goodsserver.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-07
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {

    @Override
    public boolean save(Type type) {
        type.setCreateTime(System.currentTimeMillis());
        type.setUpdateTime(System.currentTimeMillis());
        return super.save(type);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public List<Type> list(Wrapper<Type> wrapper) {
        return baseMapper.selectList(wrapper);
    }

}
