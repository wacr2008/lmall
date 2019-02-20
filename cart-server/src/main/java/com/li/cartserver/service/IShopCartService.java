package com.li.cartserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.cartserver.model.ShopCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 购物车表 服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
public interface IShopCartService extends IService<ShopCart> {


    @Override
    boolean save(ShopCart shopCart);

    @Override
    boolean removeById(Serializable serializable);

    boolean isExits(int userId,int goodsId);

    IPage<ShopCart> selectPageExt(int userId, int page, int pageSize);
}


