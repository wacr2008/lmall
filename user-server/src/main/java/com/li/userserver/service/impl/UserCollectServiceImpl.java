package com.li.userserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.userserver.model.UserCollect;
import com.li.userserver.mapper.UserCollectMapper;
import com.li.userserver.service.IUserCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
@Service
public class UserCollectServiceImpl extends ServiceImpl<UserCollectMapper, UserCollect> implements IUserCollectService {

    @Override
    public boolean save(UserCollect entity) {
        return super.save(entity);
    }

    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @Override
    public boolean deleteCollectByGoodsId(int goodsId,int userId) {
        QueryWrapper<UserCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(UserCollect::getGoodsId,goodsId)
                .eq(UserCollect::getUserId,userId);
        int delete = baseMapper.delete(queryWrapper);
        if (delete > 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExitsGoods(int goodsId,int userId) {
        QueryWrapper<UserCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(UserCollect::getGoodsId,goodsId)
        .eq(UserCollect::getUserId,userId);

        UserCollect userCollect = baseMapper.selectOne(queryWrapper);

        if (userCollect == null){
            System.out.println(userCollect);
            return false;
        }
        return true;
    }

    @Override
    public IPage<UserCollect> selectGoodsByPage(int userId, int page, int pageSize) {
        QueryWrapper<UserCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(UserCollect::getGoodsId,UserCollect::getGoodsImg,UserCollect::getGoodsName,UserCollect::getGoodsPrice)
                .eq(UserCollect::getUserId,userId);
        Page<UserCollect> goodsPage = new Page<>(page, pageSize);
        return baseMapper.selectPage(goodsPage,queryWrapper);
    }


}
