package com.li.goodsserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.Slideshow;
import com.li.goodsserver.mapper.SlideshowMapper;
import com.li.goodsserver.service.ISlideshowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
@Service
public class SlideshowServiceImpl extends ServiceImpl<SlideshowMapper, Slideshow> implements ISlideshowService {

    @Override
    public boolean save(Slideshow entity) {
        return super.save(entity);
    }

    @Override
    public List<Slideshow> selectSlideshows(Wrapper<Slideshow> wrapper) {
        return baseMapper.selectList(wrapper);
    }
}
