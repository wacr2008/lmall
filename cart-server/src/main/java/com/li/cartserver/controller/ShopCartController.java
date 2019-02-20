package com.li.cartserver.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.cartserver.bo.RestResponseBo;
import com.li.cartserver.model.ShopCart;
import com.li.cartserver.service.IShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 购物车表 前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/shop-cart")
public class ShopCartController {

    @Autowired
    private IShopCartService shopCartService;

    @RequestMapping("/insert")
    public RestResponseBo insert(HttpServletRequest request,ShopCart shopCart){
        int userId = (int) request.getSession().getAttribute("userId");
        shopCart.setUserId(userId);
        shopCartService.save(shopCart);
        return RestResponseBo.ok();
    }

    @RequestMapping("/isExits")
    public RestResponseBo isExits(HttpServletRequest request,int goodsId){
        int userId = (int) request.getSession().getAttribute("userId");
        boolean exits = shopCartService.isExits(userId, goodsId);
        // true 存在 false 不存在
        if (exits){
            return RestResponseBo.ok();
        } else {
            return RestResponseBo.fail();
        }
    }

    @RequestMapping("/select")
    public RestResponseBo selectPage(HttpServletRequest request,int page,int pageSize){
        int userId = (int) request.getSession().getAttribute("userId");
        IPage<ShopCart> shopCartIPage = shopCartService.selectPageExt(userId, page, pageSize);
        List<ShopCart> shopCartList = shopCartIPage.getRecords();
        long pages = shopCartIPage.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("shopCartList", shopCartList);
        map.put("pages", pages);
        return RestResponseBo.ok(map, 000);
    }
}

