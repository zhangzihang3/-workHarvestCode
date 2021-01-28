package com.zzh.mybatisplusdaynamicannotationsql;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zzh.mybatisplusdaynamicannotationsql.config.paramsConfig;
import com.zzh.mybatisplusdaynamicannotationsql.entity.Goods;
import com.zzh.mybatisplusdaynamicannotationsql.mapper.GoodsMapper;
import com.zzh.mybatisplusdaynamicannotationsql.service.GoodsService;
import com.zzh.mybatisplusdaynamicannotationsql.service.impl.GoodsServiceImpl;
import com.zzh.mybatisplusdaynamicannotationsql.utils.webUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisplusDaynamicAnnotationSqlApplicationTests {
    @Autowired
    GoodsServiceImpl goodsService;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    com.zzh.mybatisplusdaynamicannotationsql.config.paramsConfig paramsConfig;

    @Test
    void test() {
        Goods byId = goodsService.getById(1);
        System.out.println(byId);
    }
    @Test
    void testInitializingBean() {
        goodsService.testInitializingBean();
    }

    @Test
    void testDaynamicAnnotationSql() {
        List<Goods> select = goodsMapper.select(12, 20);
        Iterator<Goods> iterator = select.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Test
    void testParamsConfig() {
        System.out.println(paramsConfig.getGoodName());
        System.out.println(paramsConfig.getGoodPrice());
        System.out.println(paramsConfig.getGoodbad());
        System.out.println(paramsConfig.getJGoodPrice());
    }

    @Test
    void testLocalDateTime() {
        System.out.println(LocalDateTime.now());
    }

    @Test
    void testAutoFill() {
        Goods goods = new Goods();
        goods.setId(30).setName("zzh").setPrice(100D).setRemark("张子行5").setGoodsTypeId(666).setStock(10);
//        goodsService.save(goods);
        UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
        goodsUpdateWrapper.eq("id", 30).set("name", "张子行666");
//        goodsService.update(null, goodsUpdateWrapper);
        goodsService.update(goods, goodsUpdateWrapper);
//        goodsService.update(goodsUpdateWrapper);

    }

    @Test
    void testWebUtil() {
        goodsService.testWebUtil();
    }
}
