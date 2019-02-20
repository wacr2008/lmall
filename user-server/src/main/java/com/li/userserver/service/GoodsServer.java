package com.li.userserver.service;

import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.hystric.GoodsServerHystrix;
import com.li.userserver.utils.FeignUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author lihaodong
 * @Description
 * @Date 11:28 2019/1/17
 * @Param
 * @return
 **/
@FeignClient(name = "goods-server",configuration = FeignUtil.class,fallback = GoodsServerHystrix.class)
public interface GoodsServer {

    @RequestMapping(value = "/goods-sku/update",method = RequestMethod.POST)
    RestResponseBo getRegisterCode(@RequestParam("goodsId") int goodsId,@RequestParam("num") int num);
}
