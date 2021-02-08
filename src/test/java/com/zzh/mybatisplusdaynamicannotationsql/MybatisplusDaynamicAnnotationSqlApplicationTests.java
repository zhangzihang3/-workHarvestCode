package com.zzh.mybatisplusdaynamicannotationsql;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzh.mybatisplusdaynamicannotationsql.config.ymlConfigurationProperties;
import com.zzh.mybatisplusdaynamicannotationsql.entity.Goods;
import com.zzh.mybatisplusdaynamicannotationsql.mapper.GoodsMapper;
import com.zzh.mybatisplusdaynamicannotationsql.service.impl.GoodsServiceImpl;
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
    @Autowired
    com.zzh.mybatisplusdaynamicannotationsql.config.ymlConfigurationProperties ymlConfigurationProperties;

    /**
     * 逻辑删除
     */
    @Test
    void testLogicDeleted() {
        goodsService.remove(new QueryWrapper<Goods>().eq("stock", 10000));
        goodsService.removeById(31);
        goodsMapper.deleteById(30);
    }

    /**
     * 事务
     */
    @Test
    void testTransactional() {
        goodsService.tranferMoney();
    }

    /**
     * 分页
     */
    @Test
    void testPage() {
        Wrapper<Goods> queryWrapper = new LambdaQueryWrapper<Goods>()
                .eq(Goods::getName, "zzh");
        Page<Goods> goodsPage = new Page<>(1, 10);
        System.out.println(goodsService.page(goodsPage, queryWrapper).getRecords());
    }

    /**
     * 乐观锁
     */
    @Test
    void testOptimisticLocker() {
        Goods byId = goodsService.getById(30);
        byId.setPrice(8989D);
        byId.setStock(9090);
        goodsService.updateById(byId);
    }

    /**
     * 序列化
     */
    @Test
    void testJsonSerialize() {
        System.out.println(ymlConfigurationProperties.getMap().toString());
    }

    /**
     * testInitializingBean
     */
    @Test
    void testInitializingBean() {
        goodsService.testInitializingBean();
    }

    /**
     * 动态sql
     */
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

    /**
     * 自动填充
     */
    @Test
    void testAutoFill() {
        Goods goods = new Goods();
        goods.setId(30).setName("zzh").setPrice(100D).setRemark("张子行5").setGoodsTypeId(666).setStock(11);
//        goodsService.save(goods);
        UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
        goodsUpdateWrapper.eq("id", 30);
        //只更新需要更新的字段其他字段不会动
        //goodsService.update(null, goodsUpdateWrapper);
        //goodsService.update(goods, goodsUpdateWrapper);
        goodsService.updateById(goods);
        //goodsService.update(goodsUpdateWrapper);

    }

    @Test
    void testWebUtil() {
        goodsService.testWebUtil();
    }
}
