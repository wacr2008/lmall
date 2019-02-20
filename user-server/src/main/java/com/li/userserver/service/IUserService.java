package com.li.userserver.service;

import com.li.userserver.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.li.userserver.utils.FeignUtil;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
public interface IUserService extends IService<User> {

    @Override
    boolean save(User user);

    boolean isExists(String phone);

    User login(User user);

    String transfer();


}
