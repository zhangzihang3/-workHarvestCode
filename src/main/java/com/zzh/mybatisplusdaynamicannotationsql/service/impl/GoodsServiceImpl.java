package com.zzh.mybatisplusdaynamicannotationsql.service.impl;

import com.zzh.mybatisplusdaynamicannotationsql.config.testBean;
import com.zzh.mybatisplusdaynamicannotationsql.entity.Goods;
import com.zzh.mybatisplusdaynamicannotationsql.mapper.GoodsMapper;
import com.zzh.mybatisplusdaynamicannotationsql.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzh.mybatisplusdaynamicannotationsql.utils.webUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzh
 * @since 2021-01-26
 */
@Service
@Slf4j
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public void testWebUtil() {
        log.error("设备类型: " + webUtil.getDeviceType());
        log.error("获取GoodsServiceImpl bean: " + webUtil.getBean(GoodsServiceImpl.class));
        log.error("是否是ajax请求: " + webUtil.isAjax(webUtil.getCurrentRequest()));
        log.error("当前请求的ip: " + webUtil.getIpAddr(webUtil.getCurrentRequest()));
    }

    public void testInitializingBean() {
        log.error("goodName: " + testBean.GOODNAME);
        log.error("goodPrice: " + testBean.GOODPRICE);
    }

    @Transactional
    public void tranferMoney() {
        goodsMapper.upMoney();
        //int error = 1/0;
        goodsMapper.downMoney();
    }
}
