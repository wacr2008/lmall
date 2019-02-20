package com.li.userserver.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.li.userserver.model.ReceiverAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-14
 */
public interface ReceiverAddressMapper extends BaseMapper<ReceiverAddress> {

    @Override
    int insert(ReceiverAddress receiverAddress);

    @Override
    int updateById(ReceiverAddress receiverAddress);

    @Override
    IPage<ReceiverAddress> selectPage(IPage<ReceiverAddress> iPage,@Param("ew") Wrapper<ReceiverAddress> wrapper);
}
