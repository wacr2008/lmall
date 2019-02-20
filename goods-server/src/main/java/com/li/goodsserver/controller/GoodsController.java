package com.li.goodsserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.goodsserver.bo.RestResponseBo;
import com.li.goodsserver.model.Brand;
import com.li.goodsserver.model.Goods;
import com.li.goodsserver.redis.RedisService;
import com.li.goodsserver.service.IBrandService;
import com.li.goodsserver.service.IGoodsService;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品请求层
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IBrandService brandService;

    @Autowired
    private RedisService redisService;


    @RequestMapping("/insert")
    public RestResponseBo insert(Goods goods) {
        try {
            goodsService.save(goods);
            return RestResponseBo.ok(000);
        } catch (Exception e) {
            log.error("插入商品失败,失败原因:{}", e.getMessage());
            return RestResponseBo.fail(300, "插入商品失败");
        }
    }

    @RequestMapping("/selectHotGoods")
    public RestResponseBo selectHotGoodsList() {
        try {
            List<Goods> goodsList = goodsService.selectHotGoods();
            return RestResponseBo.ok(goodsList, 000);
        } catch (Exception e) {
            log.error("查询爆款商品失败,失败原因:{}", e.getMessage());
            return RestResponseBo.fail(300, "查询爆款商品失败");
        }
    }

    @RequestMapping("/selectGoods")
    public RestResponseBo selectGoodsById(int id) {
        try {
            Goods goods = goodsService.getById(id);
            return RestResponseBo.ok(goods, 000);
        } catch (Exception e) {
            log.error("查询商品失败,失败原因:{}", e.getMessage());
            return RestResponseBo.fail(300, "查询商品失败");
        }
    }
    @RequestMapping("/selectGoodsByType")
    public RestResponseBo selectGoodsByType(Goods goods, int page, int pageSize) {
        try {
            List<Brand> brandList = new ArrayList<>();
            if (page == 1) {
                // 品牌内容
                Brand brand = new Brand();
                brand.setBrandId(0);
                brand.setBrandName("全部");
                brandList = (List<Brand>) redisService.getBrandList("brand", "type_" + goods.getType_id());
                brandList.add(0, brand);
            }
            // 分页内容
            IPage<Goods> goodsIPage = goodsService.selectPageExt(goods, page, pageSize);
            List<Goods> goodsList = goodsIPage.getRecords();
            Map<String, Object> map = new HashMap<>();
            long totalPage = goodsIPage.getPages();
            map.put("goodsList", goodsList);
            map.put("brandList", brandList);
            map.put("totalPage", totalPage);
            return RestResponseBo.ok(map, 000);
        } catch (Exception e) {
            log.error("查询类型商品失败,失败原因:{}", e.getMessage());
            return RestResponseBo.fail(300, "查询商品失败");
        }
    }

    @RequestMapping("/selectGoodsByBrand")
    public RestResponseBo selectGoodsByBrand(Goods goods, int page, int pageSize) {
        try {
            // 分页内容
            IPage<Goods> goodsIPage = goodsService.selectGoodsPageByBrandId(goods, page, pageSize);
            List<Goods> goodsList = goodsIPage.getRecords();
            Map<String, Object> map = new HashMap<>();
            long totalPage = goodsIPage.getPages();
            map.put("goodsList", goodsList);
            map.put("totalPage", totalPage);
            return RestResponseBo.ok(map, 000);
        } catch (Exception e) {
            log.error("查询品牌商品失败,失败原因:{}", e.getMessage());
            return RestResponseBo.fail(300, "查询商品失败");
        }
    }

    @RequestMapping("/selectGoodsByGoodsId")
    public RestResponseBo selectGoodsByGoodsId(int goodsId) {
        try {
            Map<String, Object> map = goodsService.selectGoodsByGoodsId(goodsId);
            return RestResponseBo.ok(map, 000);
        } catch (Exception e) {
            log.error("查询商品失败,失败原因:{}", e.getMessage());
            return RestResponseBo.fail(300, "查询商品失败");
        }
    }

}

