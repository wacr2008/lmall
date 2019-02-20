package com.li.userserver.hystric;

import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.service.GoodsServer;
import com.li.userserver.service.MessageServer;
import org.springframework.stereotype.Component;

/**
 * @Author lihaodong
 * @Description 调用短信服务
 * @Date 11:43 2019/1/17
 * @Param
 * @return
 **/
@Component
public class GoodsServerHystrix implements GoodsServer {

    @Override
    public RestResponseBo getRegisterCode(int goodsId, int num) {
        return RestResponseBo.fail("服务器异常");
    }
}
