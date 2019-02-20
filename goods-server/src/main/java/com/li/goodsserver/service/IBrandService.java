package com.li.goodsserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
public interface IBrandService extends IService<Brand> {

    @Override
    boolean save(Brand brand);

    List<Brand> selectBrandByTypeId(Wrapper<Brand> brandWrapper);

    /**
     * @Author lihaodong
     * @Description 
     * @Date 11:36 2019/1/9
     * @Param []
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    List<Map<String,Object>> goodsClassify();
}
