package com.li.orderserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
@Setter
@Getter
@TableName("sys_order_info")
public class OrderInfo extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * uuid 字符串唯一  不自增
     */
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    /**
     * 订单号 格式:当前时间+流水号
     */
    @TableField("orderId")
    private String orderId;

    /**
     * 商品标题
     */
    @TableField("goods_title")
    private String goodsTitle;

    /**
     * 商品单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 订单金额
     */
    @TableField("count_money")
    private BigDecimal countMoney;

    /**
     * 商品封面
     */
    @TableField("goods_img")
    private String goodsImg;

    /**
     * 商品规格信息
     */
    @TableField("specifications_info")
    private String specificationsInfo;

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
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 支付方式 1 支付宝 2微信
     */
    @TableField("pay_method")
    private Integer payMethod;

    /**
     * 订购数量
     */
    @TableField("num")
    private Integer num;

    /**
     * 运费
     */
    @TableField("freight")
    private BigDecimal freight;

    /**
     * 状态 1 未付款 2 已付款 3 未发货 4 已发货 5 已签收 6 已关闭
     */
    @TableField("state")
    private Integer state;

    /**
     * 付款时间
     */
    @TableField("pay_time")
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    @TableField("delivery_time")
    private LocalDateTime deliveryTime;

    /**
     * 收货时间(签收的时间)
     */
    @TableField("receiving_time")
    private LocalDateTime receivingTime;

    /**
     * 是否评价 0 未评价 1已评价
     */
    @TableField("is_comment")
    private Integer isComment;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 商品id
     */
    @TableField("goods_id")
    private Integer goodsId;

    /**
     * 收货地址表id
     */
    @TableField("address_id")
    private Integer addressId;


    /**
     * 创建时间(也是订单创建的时间)
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;

    /**
     * 0-正常，1-删除
     */
    @TableField("del_flag")
    private Integer delFlag;


}
