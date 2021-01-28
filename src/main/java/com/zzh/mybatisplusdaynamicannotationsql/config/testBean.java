package com.zzh.mybatisplusdaynamicannotationsql.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class testBean implements InitializingBean {
    @Value("${Good.name}")
    public String goodName;
    @Value("#{100}")
    private String goodPrice;
    public static String GOODNAME;
    public static String GOODPRICE;

    public testBean() {
        System.out.println("testBean创建");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("testBean创建之后进行属性设置");
        GOODNAME = this.goodName;
        GOODPRICE = this.goodPrice;
    }
}
