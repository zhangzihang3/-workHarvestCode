package com.zzh.mybatisplusdaynamicannotationsql.diyJsonData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author 张子行
 * @class
 */

/**
 * 类中有字段为null时不返回给前端
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
public class money {

    private int amount;
    /**
     * 使用自定义的序列化规则
     */
    @JsonSerialize(using = DateSerializer.class)
    private LocalDateTime date;
    /**
     * 为空时不会返回给前端
     */
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String unit;
    /**
     * 序列化不返回给前端的字段
     */
    @JsonIgnore
    private String name;
}