package com.li.goodsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.goodsserver.model.Goods;
import com.li.goodsserver.mapper.GoodsMapper;
import com.li.goodsserver.model.GoodsImg;
import com.li.goodsserver.model.GoodsSku;
import com.li.goodsserver.service.IGoodsImgService;
import com.li.goodsserver.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.goodsserver.service.IGoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
@Slf4j
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
    private IGoodsImgService goodsImgService;
    @Autowired
    private IGoodsSkuService goodsSkuService;

    @Override
    public boolean save(Goods entity) {
        return super.save(entity);
    }

    @Override
    public List<Goods> selectGoodsList(Wrapper<Goods> wrapper) {
        return baseMapper.selectList(wrapper);
    }

    @Override
    public Goods getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<Goods> selectHotGoods() {
        return baseMapper.selectHotGoods();
    }

    @Override
    public IPage<Goods> selectPageExt(Goods goods, int page, int pageSize) {
        try {
            Page<Goods> goodsPage = new Page<>(page, pageSize);
            QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(Goods::getType_id,goods.getType_id());
            return baseMapper.selectPage(goodsPage,queryWrapper);
        } catch (Exception e) {
            log.error("查询类型商品失败:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public IPage<Goods> selectGoodsPageByBrandId(Goods goods, int page, int pageSize) {
        try {
            Page<Goods> goodsPage = new Page<>(page, pageSize);
            QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(Goods::getBrand_id,goods.getBrand_id());
            return baseMapper.selectPage(goodsPage,queryWrapper);
        } catch (Exception e) {
            log.error("查询品牌商品失败:{}",e.getMessage());
            return null;
        }
    }

    @Override
    public Map<String, Object> selectGoodsByGoodsId(int goodsId) {
        Map<String,Object> map = new HashMap<>();
        Goods goods = getById(goodsId);
        List<GoodsImg> goodsImgs = goodsImgService.selectGoodsImgByGoodsId(goodsId);
        List<GoodsSku> goodsSkus = goodsSkuService.selectGoodsSkuByGoodsId(goodsId);
        map.put("goods",goods);
        map.put("goodsImg",goodsImgs);
        map.put("goodsSku",goodsSkus);
        return map;
    }


    @Override
    public boolean updateById(Goods entity) {
        return super.updateById(entity);
    }
}
