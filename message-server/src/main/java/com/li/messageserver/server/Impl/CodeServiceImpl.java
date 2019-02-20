package com.li.messageserver.server.Impl;

import com.li.messageserver.server.CodeServer;
import com.li.messageserver.utils.SendMsg;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName NoteServiceImpl
 * @Author lihaodong
 * @Date 2019/1/21 22:33
 * @Mail lihaodongmail@163.com
 * @Description 短信服务实现类
 * @Version 1.0
 **/
@Service
public class CodeServiceImpl implements CodeServer {
    /**
     * 随机数
     */
    private static int randNum = (int) ((Math.random() * 9 + 1) * 100000);
    /**
     * 注册短信
     */
    private final static String REGISTER_TEMPLATE = "【小东商城】注册验证码：" + randNum + "，如非本人操作，请忽略此短信。";
    /**
     * 登录短信
     */
    public final static String LOGIN_TEMPLATE = "【小东科技】登录验证码：+randNum+，如非本人操作，请忽略此短信。";

    @Override
    public Map<String, Object> registerCode(String phone) {
        Map<String, Object> map = SendMsg.sendSMSG(phone, REGISTER_TEMPLATE,randNum);
        return map;
    }
}
