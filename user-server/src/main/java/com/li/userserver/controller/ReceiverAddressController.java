package com.li.userserver.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.model.ReceiverAddress;
import com.li.userserver.service.IReceiverAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
@RestController
@RequestMapping("/address")
public class ReceiverAddressController {

    @Autowired
    IReceiverAddressService receiverAddressService;

    @RequestMapping("/insert")
    public RestResponseBo insertAddress(ReceiverAddress receiverAddress,HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("userId");
        receiverAddress.setUserId(userId);
        receiverAddressService.save(receiverAddress);
        return RestResponseBo.ok();
    }

    @RequestMapping("/selectAddress")
    public RestResponseBo selectAddressByUserId(HttpServletRequest request,int page,int pageSize){
        int userId = (int) request.getSession().getAttribute("userId");
        IPage<ReceiverAddress> receiverAddressPage = receiverAddressService.selectPageExt(userId, page, pageSize);
        List<ReceiverAddress> addressList = receiverAddressPage.getRecords();
        long pages = receiverAddressPage.getPages();
        Map<String, Object> map = new HashMap<>();
        map.put("addressList", addressList);
        map.put("pages", pages);
        return RestResponseBo.ok(map, 000);
    }

}

