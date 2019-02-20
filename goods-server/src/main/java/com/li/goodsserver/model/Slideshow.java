package com.li.goodsserver.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihaodong
 * @since 2019-01-08
 */
@Data
@TableName("sys_slideshow")
public class Slideshow extends Model<Slideshow> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "slideshowId", type = IdType.AUTO)
    private Integer slideshowId;

    @TableField("slideImg")
    private String slideImg;

    @TableField("slideshowDescribe")
    private String slideshowDescribe;

    @TableField("createTime")
    private Long createTime;

    @TableField("updateTime")
    private Long updateTime;


}
