package com.li.goodsserver.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.goodsserver.model.Slideshow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
public interface ISlideshowService extends IService<Slideshow> {

    @Override
    boolean save(Slideshow slideshow);

    List<Slideshow> selectSlideshows(Wrapper<Slideshow> wrapper);
}
