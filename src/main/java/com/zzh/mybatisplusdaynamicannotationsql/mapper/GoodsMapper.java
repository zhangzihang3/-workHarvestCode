package com.zzh.mybatisplusdaynamicannotationsql.mapper;

import com.zzh.mybatisplusdaynamicannotationsql.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author zzh
 * @since 2021-01-26
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("<script>"
            + "select * from goods where id between"
            + "<if test='#{idMin}!=null'>" + "#{idMin} and " + "</if>"
            + "<if test='#{idMax}!=null'>" + "#{idMax}" + "</if>"
            + "</script>")
    public List<Goods> select(@Param("idMin") Integer idMin, @Param("idMax") Integer idMax);

    public void upMoney();

    public void downMoney();

}
