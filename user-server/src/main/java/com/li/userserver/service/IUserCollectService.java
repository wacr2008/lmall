package com.li.userserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.userserver.model.UserCollect;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
public interface IUserCollectService extends IService<UserCollect> {

    @Override
    boolean save(UserCollect userCollect);

    @Override
    boolean removeById(Serializable serializable);

    boolean deleteCollectByGoodsId(int goodsId,int userId);

    boolean isExitsGoods(int goodsId,int userId);

    IPage<UserCollect> selectGoodsByPage(int userId, int page, int pageSize);



}
