package com.li.goodsserver.controller;


import com.li.goodsserver.bo.RestResponseBo;
import com.li.goodsserver.model.Goods;
import com.li.goodsserver.model.GoodsSku;
import com.li.goodsserver.service.IGoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
@Slf4j
@RestController
@RequestMapping("/goods-sku")
public class GoodsSkuController {

    @Autowired
    private IGoodsSkuService goodsSkuService;

    @RequestMapping("/update")
    public RestResponseBo updateGoods(int goodsId, int num) {

//        try {
            GoodsSku goodsSku = goodsSkuService.getById(goodsId);
            int s = Integer.parseInt(goodsSku.getStock())-num;
            goodsSku.setStock(String.valueOf(s));
        boolean b = goodsSkuService.updateById(goodsSku);
        if (b){
            return RestResponseBo.ok();
        } else {
            return RestResponseBo.fail();
        }
//        } catch (Exception e) {
//            log.error("库存修改失败,原因{}",e.getMessage());
//            return RestResponseBo.fail(300, "库存修改失败");
//        }
    }

}

