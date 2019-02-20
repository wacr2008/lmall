package com.li.goodsserver.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName GoodsVo
 * @Author lihaodong
 * @Date 2019/1/6 21:56
 * @Mail lihaodongmail@163.com
 * @Description 商品类
 * @Version 1.0
 **/

@ToString
@Setter
@Getter
@TableName("sys_goods")
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    // 商品Id
    @TableId(value = "goodsId", type = IdType.AUTO)
    private Integer goodsId;

    // 商品名称
    @TableField("goodsName")
    private String goodsName;

    // 商品描述
    @TableField("goodsDescribe")
    private String goodsDescribe;

    // 商品价格
    @TableField("goodsPrice")
    private BigDecimal goodsPrice;

    // 商品详情
    @TableField("detailsShows")
    private String detailsShows;

    // 商品参数 暂空
    @TableField("parameters")
    private String parameters;

    // 卖出数量
    @TableField("sellQuantity")
    private int sellQuantity;

    // 默认展示照片
    @TableField("defaultShow")
    private String defaultShow;

    // 品牌
    @TableField("brand_id")
    private int brand_id;

    // 类型
    @TableField("type_id")
    private int type_id;


}
