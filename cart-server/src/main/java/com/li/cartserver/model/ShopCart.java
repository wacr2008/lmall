package com.li.cartserver.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 购物车表
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-21
 */
@Setter
@Getter
@TableName("sys_shop_cart")
public class ShopCart extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 订购数量
     */
    @TableField("num")
    private Integer num;

    /**
     * 商品标题
     */
    @TableField("title")
    private String title;

    /**
     * 商品单价
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 总价格
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
     * 创建时间
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
