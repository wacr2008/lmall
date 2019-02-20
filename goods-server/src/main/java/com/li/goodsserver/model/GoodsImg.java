package com.li.goodsserver.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

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
@TableName("sys_goods_img")
public class GoodsImg extends Model<GoodsImg> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "goods_id")
    private Integer goodsId;

    @TableField(value = "img")
    private String img;

    @TableField(value = "add_time")
    private Long addTime;


}
