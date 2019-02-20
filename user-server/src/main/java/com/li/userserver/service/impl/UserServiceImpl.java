package com.li.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.li.userserver.bo.RestResponseBo;
import com.li.userserver.model.User;
import com.li.userserver.mapper.UserMapper;
import com.li.userserver.service.GoodsServer;
import com.li.userserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    // 远程
    @Autowired
    private GoodsServer goodsServer;


    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public boolean isExists(String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(User::getPhone).eq(User::getPhone, phone);
        List<User> userList = baseMapper.selectList(queryWrapper);
        if (userList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(User::getPhone, User::getEmail, User::getUserId, User::getUsername)
                .eq(User::getPhone, user.getPhone())
                .eq(User::getPassword, user.getPassword());
        List<User> userList = baseMapper.selectList(queryWrapper);
        return userList.get(0);
    }

    @LcnTransaction //分布式事务注解
    @Transactional //本地事务注解
    @Override
    public String transfer() {
        User user = new User();
        user.setAge(1);
        user.setUsername("1");
        user.setPassword("123");
        boolean save = save(user);

        // 远程
        RestResponseBo registerCode = goodsServer.getRegisterCode(3, 1);
//        int i = 1 / 0;
        System.out.println(registerCode.isSuccess());
        return String.valueOf(save)+ " > " + "ok-goods";
    }
}
