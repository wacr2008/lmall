package com.li.userserver.service;

import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.hystric.MessageServerHystrix;
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
@FeignClient(name = "message-server",configuration = FeignUtil.class,fallback = MessageServerHystrix.class)
public interface MessageServer {

    @RequestMapping(value = "/note/sendCode",method = RequestMethod.POST)
    RestResponseBo getRegisterCode(@RequestParam("phone") String phone);
}
