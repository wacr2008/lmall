package com.li.userserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author lihaodong
 * @Description 收货地址
 * @Date 17:32 2019/1/14
 * @Param
 * @return
 **/
@Setter
@Getter
@TableName("sys_receiver_address")
public class ReceiverAddress extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 手机号
     */
    @TableField(value = "tel")
    private String tel;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 地区
     */
    @TableField(value = "county")
    private String county;

    /**
     * 地址详情
     */
    @TableField("addressDetail")
    private String addressDetail;

    /**
     * 邮政编码
     */
    @TableField("postalCode")
    private String postalCode;

    /**
     * 是否默认
     */
    @TableField("isDefault")
    private String isDefault;

    /**
     * 用户标识
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 总的地址
     */
    @TableField("address")
    private String address;

}
