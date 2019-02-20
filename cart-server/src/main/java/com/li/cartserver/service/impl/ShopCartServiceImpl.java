package com.li.cartserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.cartserver.model.ShopCart;
import com.li.cartserver.mapper.ShopCartMapper;
import com.li.cartserver.service.IShopCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 购物车表 服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
@Service
public class ShopCartServiceImpl extends ServiceImpl<ShopCartMapper, ShopCart> implements IShopCartService {

    @Override
    public boolean save(ShopCart entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean isExits(int userId, int goodsId) {
        QueryWrapper<ShopCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(ShopCart::getId,ShopCart::getId)
                .eq(ShopCart::getUserId,userId)
                .eq(ShopCart::getGoodsId,goodsId);
        ShopCart shopCart = baseMapper.selectOne(queryWrapper);
        if (shopCart!= null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public IPage<ShopCart> selectPageExt(int userId, int page, int pageSize) {
        Page<ShopCart> goodsPage = new Page<>(page, pageSize);
        QueryWrapper<ShopCart> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(ShopCart::getGoodsId,ShopCart::getGoodsImg,ShopCart::getNum,ShopCart::getPrice)
                .eq(ShopCart::getUserId,userId);
        return baseMapper.selectPage(goodsPage,queryWrapper);
    }
}
