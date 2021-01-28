package com.zzh.mybatisplusdaynamicannotationsql.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张子行
 * @class mybatisPlus属性自动填充，对应的实体类字段上需要加@TableField(fill = FieldFill.INSERT_UPDATE)
 */
@Configuration
@Slf4j
public class autoFillConfig implements MetaObjectHandler {
    /**
     * @param
     * @method 插入时自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时自动填充");
        this.setFieldValByName("stock", 1, metaObject);
    }

    /**
     * @param
     * @method 更新时自动填充, 这个没啥意义。
     * 更新时必须携带实体类，goodsService.update(goods, goodsUpdateWrapper);
     * 且自动填充的优先级>实体类中即使设置了该属性的优先级
     * goodsUpdateWrapper更新的字段值优先级>实体类中即使设置了该属性的优先级
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时自动填充");
        this.setFieldValByName("stock", -9090, metaObject);
    }
}
