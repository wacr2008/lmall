package com.li.goodsserver.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-12
 */
@Setter
@Getter
@TableName("sys_goods_sku")
public class GoodsSku extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "goods_id")
    private Integer goodsId;

    // 价格
    @TableField(value = "price")
    private BigDecimal price;

    // 库存
    @TableField(value = "stock")
    private String stock;

    // 规格
    @TableField(value = "specification")
    private String specification;

    @TableField(value = "goodsImg")
    private String goodsImg;


}
