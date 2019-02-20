package com.li.cartserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.cartserver.model.ShopCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 购物车表 Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
public interface ShopCartMapper extends BaseMapper<ShopCart> {

    /**
     * @Author lihaodong
     * @Description 添加商品到购物车
     * @Param [shopCart]
     * @return int
     **/
    @Override
    int insert(ShopCart shopCart);

    /**
     * @Author lihaodong
     * @Description 通过id进行删除
     * @Param [serializable]
     * @return int
     **/
    @Override
    int deleteById(Serializable serializable);

    @Override
    ShopCart selectOne(@Param("ew") Wrapper<ShopCart> wrapper);

    @Override
    IPage<ShopCart> selectPage(IPage<ShopCart> iPage,@Param("ew") Wrapper<ShopCart> wrapper);
}
