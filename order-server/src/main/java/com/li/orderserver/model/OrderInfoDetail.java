package com.li.orderserver.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单明细表
 * </p>
 *
 * @author lihaodong
 * @since 2019-02-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_order_info_detail")
public class OrderInfoDetail extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 订单明细uuid
     */
    private String id;

    /**
     * 商品表id
     */
    private Integer goodsId;

    /**
     * 订单表id
     */
    private String orderInfoId;

    /**
     * 订购数量
     */
    private Integer num;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品单价
     */
    private Double price;

    /**
     * 总价格
     */
    private Double countMoney;

    /**
     * 商品封面
     */
    private String goodsImg;

    /**
     * 商品规格信息
     */
    private String specificationsInfo;

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
    private Integer delFlag;


}
