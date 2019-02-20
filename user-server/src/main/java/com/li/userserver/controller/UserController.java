package com.li.userserver.controller;


import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.model.User;
import com.li.userserver.redis.RedisService;
import com.li.userserver.service.IUserService;
import com.li.userserver.service.MessageServer;
import com.li.userserver.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private IUserService userService;
    @Autowired
    private MessageServer messageServer;

    /**
     * @return com.li.userserver.bo.RestResponseBo
     * @Author lihaodong
     * @Description 用户注册短信
     * @Date 15:07 2019/1/16
     * @Param [phone]
     **/
    @RequestMapping("/sendCode")
    public RestResponseBo sendMessage(String phone) {
        try {
            RestResponseBo responseBo = messageServer.getRegisterCode(phone);
            if (responseBo.isSuccess()) {
                redisService.savePhoneCode(phone, (String) responseBo.getPayload(), 2);
                return RestResponseBo.ok("发送成功", 100);
            } else {
                return RestResponseBo.fail(responseBo.getMsg());
            }
        } catch (Exception e) {
            log.error("发送短信失败,{}", e.getMessage());
            return RestResponseBo.fail(102, "服务器在偷懒哦");
        }
    }

    /**
     * @return com.li.userserver.bo.RestResponseBo
     * @Author lihaodong
     * @Description 验证验证码是否有效
     * @Date 15:07 2019/1/16
     * @Param [phone, code]
     **/
    @RequestMapping("/checkCode")
    public RestResponseBo checkCode(String phone, String code) {
        String s = redisService.get(phone);
        if (s != null) {
            if (s.equals(code)) {
                return RestResponseBo.ok(100);
            }
            return RestResponseBo.fail(101, "验证码错误");
        }
        return RestResponseBo.fail(102, "验证码已过期,请重新获取");
    }

    /**
     * @return com.li.userserver.bo.RestResponseBo
     * @Author lihaodong
     * @Description 注册用户
     * @Date 15:06 2019/1/16
     * @Param [user]
     **/
    @RequestMapping("/addUser")
    public RestResponseBo addUser(User user) {
        try {
            String phone = user.getPhone();
            user.setUsername(phone.substring(phone.length() - 4));
            String dbPass = Md5Util.inputPass2DBPass(user.getPassword());
            user.setPassword(dbPass);
            userService.save(user);
            return RestResponseBo.ok();
        } catch (Exception e) {
            log.error("注册用户失败,原因{}", e.getMessage());
            return RestResponseBo.fail();
        }
    }

    /**
     * @return com.li.userserver.bo.RestResponseBo
     * @Author lihaodong
     * @Description 验证手机号是否存在
     * @Date 15:06 2019/1/16
     * @Param [phone]
     **/
    @RequestMapping("/isExists")
    public RestResponseBo phoneIsExists(String phone) {
        try {
            boolean exists = userService.isExists(phone);
            if (exists) {
                // 说明存在手机号
                return RestResponseBo.ok("手机号已存在", 100);
            } else {
                // 说明不存在手机号
                return RestResponseBo.ok("手机号不存在", 101);
            }
        } catch (Exception e) {
            log.error("查询手机号是否存在失败,原因{}", e.getMessage());
            return RestResponseBo.fail("服务异常,请稍后再试");
        }
    }

    @RequestMapping("/login")
    public RestResponseBo login(User user, HttpServletRequest request) {
        try {
            user.setPassword(Md5Util.formPassToDBPass(user.getPassword(), "1a2b3c4d"));
            User login = userService.login(user);
            if (login != null) {
                request.getSession().setAttribute("userId", login.getUserId());
                return RestResponseBo.ok("登陆成功", 100);
            } else {
                return RestResponseBo.ok("密码错误或账号不存在", 101);
            }
        } catch (Exception e) {
            log.error("登录失败,原因{}", e.getMessage());
            return RestResponseBo.fail("服务异常,请稍后再试");
        }
    }


    @RequestMapping("/test")
    public String login() {

        return userService.transfer();
    }


}

