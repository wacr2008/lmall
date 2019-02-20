package com.li.goodsserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName Type
 * @Author lihaodong
 * @Date 2019/1/6 21:47
 * @Mail lihaodongmail@163.com
 * @Description 类型分类
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
@TableName("sys_type")
public class Type extends Model<Type> {

    private static final long serialVersionUID = 1L;


    // 类型Id
    @TableId(value = "typeId", type = IdType.AUTO)
    private int typeId;

    // 类型名称
    @TableField("typeName")
    private String typeName;

    // 类型图标
    @TableField("typeImg")
    private String typeImg;

    // 创建时间
    @TableField("createTime")
    private long createTime;

    // 更新时间
    @TableField("updateTime")
    private long updateTime;

}
