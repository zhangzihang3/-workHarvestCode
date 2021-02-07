package com.zzh.mybatisplusdaynamicannotationsql.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zzh
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品单价")
    private Double price;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "商品库存")
    private Integer stock;

    @ApiModelProperty(value = "商品类型")
    private Integer goodsTypeId;

    @ApiModelProperty(value = "商品描述")
    private String remark;
    /**
     * @Version mybatisPlus乐观锁自动配置
     */
    @ApiModelProperty(value = "版本号")
    @Version
    private Integer version;

    /**
     * @TableLogic 逻辑删除字段,删除：1，未删除：0
     */
    @ApiModelProperty(value = "逻辑删除")
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
}
