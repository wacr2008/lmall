package com.li.goodsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.goodsserver.model.GoodsImg;
import com.li.goodsserver.mapper.GoodsImgMapper;
import com.li.goodsserver.service.IGoodsImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
@Service
public class GoodsImgServiceImpl extends ServiceImpl<GoodsImgMapper, GoodsImg> implements IGoodsImgService {

    @Override
    public List<GoodsImg> selectGoodsImgByGoodsId(int goodsId) {
        QueryWrapper<GoodsImg> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .select(GoodsImg::getId,GoodsImg::getImg)
                .eq(GoodsImg::getGoodsId,goodsId);
        return baseMapper.selectList(queryWrapper);
    }
}
