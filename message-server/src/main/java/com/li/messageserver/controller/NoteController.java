package com.li.messageserver.controller;

import com.li.messageserver.bo.RestResponseBo;
import com.li.messageserver.note.NoteTemplate;
import com.li.messageserver.server.CodeServer;
import com.li.messageserver.utils.SendMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName NoteController
 * @Author lihaodong
 * @Date 2019/1/16 11:58
 * @Mail lihaodongmail@163.com
 * @Description 短信发送服务层
 * @Version 1.0
 **/
@Slf4j
@RequestMapping("/note")
@RestController
public class NoteController {

    @Autowired
    private CodeServer codeServer;

    /**
     * @return com.li.userserver.bo.RestResponseBo
     * @Author lihaodong
     * @Description 用户注册短信
     * @Date 15:07 2019/1/16
     * @Param [phone]
     **/
    @RequestMapping("/sendCode")
    public RestResponseBo sendMessage(@RequestParam("phone") String phone) {
        try {
            Map<String, Object> map = codeServer.registerCode(phone);
            // 获取状态码 00000 成功 00141 一小时内发送给单个手机次数超过限制 00142 一天内发送给单个手机次数超过限制
            String respCode = map.get("respCode").toString();
            String securityCode = map.get("securityCode").toString();
            if ("00141".equals(respCode) || "00142".equals(respCode)) {
                return RestResponseBo.fail("发送次数过多,稍后再试");
            }
            return RestResponseBo.ok(securityCode, 100);
        } catch (Exception e) {
            log.error("发送短信失败,{}", e.getMessage());
            return RestResponseBo.fail("服务器在偷懒哦");
        }
    }

}
