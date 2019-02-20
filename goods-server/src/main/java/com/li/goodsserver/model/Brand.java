package com.li.goodsserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName BrandVo
 * @Author lihaodong
 * @Date 2019/1/6 21:36
 * @Mail lihaodongmail@163.com
 * @Description 品牌分类
 * @Version 1.0
 **/

@Getter
@Setter
@ToString
@TableName("sys_brand")
public class Brand extends Model<Brand> {

    private static final long serialVersionUID = 1L;

    // 品牌Id
    @TableId(value = "brandId", type = IdType.AUTO)
    private Integer brandId;

    // 品牌名称
    @TableField("brandName")
    private String brandName;

    // 品牌图标
    @TableField("brandImg")
    private String brandImg;

    // 父类Id 类型Id
    @TableField("type_id")
    private Integer typeId;

    // 创建时间
    @TableField("createTime")
    private Long createTime;

    // 更新时间
    @TableField("updateTime")
    private Long updateTime;

}
