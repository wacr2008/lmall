package com.li.goodsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.goodsserver.model.Brand;
import com.li.goodsserver.mapper.BrandMapper;
import com.li.goodsserver.model.Type;
import com.li.goodsserver.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.goodsserver.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private ITypeService typeService;

    @Override
    public boolean save(Brand entity) {
        entity.setCreateTime(System.currentTimeMillis());
        entity.setUpdateTime(System.currentTimeMillis());
        return super.save(entity);
    }

    @Override
    public List<Brand> selectBrandByTypeId(Wrapper<Brand> brandWrapper) {

        return baseMapper.selectList(brandWrapper);
    }

    @Override
    public List<Map<String,Object>> goodsClassify() {
        List<Map<String,Object>> goodsClassify = new ArrayList<>();
        List<Type> typeList = typeService.list(new QueryWrapper<Type>().lambda().select(Type::getTypeId, Type::getTypeName));
        typeList.forEach(type ->{
            Map<String,Object> classify = new LinkedHashMap<>();

            List<Brand> brandList = selectBrandByTypeId(new QueryWrapper<Brand>()
                    .lambda()
                    .select(Brand::getBrandId, Brand::getBrandName,Brand::getBrandImg,Brand::getTypeId)
                    .eq(Brand::getTypeId,type.getTypeId()));
            // 导航名称
            classify.put("type",type.getTypeName());
            // 该导航下所有的可选项 品牌
            classify.put("brand",brandList);
            goodsClassify.add(classify);
        });
        return goodsClassify;
    }
}
