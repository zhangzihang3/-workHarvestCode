package com.zzh.mybatisplusdaynamicannotationsql.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

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
 * @author testjava
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


}
