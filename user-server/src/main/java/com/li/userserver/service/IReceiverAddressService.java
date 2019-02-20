package com.li.userserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.userserver.model.ReceiverAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
public interface IReceiverAddressService extends IService<ReceiverAddress> {

    @Override
    boolean save(ReceiverAddress receiverAddress);

    @Override
    boolean updateById(ReceiverAddress receiverAddress);

    IPage<ReceiverAddress> selectPageExt(int userId, int page, int pageSize);

}
