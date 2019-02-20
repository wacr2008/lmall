package com.li.goodsserver.service;

import com.li.goodsserver.model.Goods;
import com.li.goodsserver.model.GoodsImg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
public interface IGoodsImgService extends IService<GoodsImg> {

    List<GoodsImg> selectGoodsImgByGoodsId(int goodsId);

}
