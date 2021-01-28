package com.zzh.mybatisplusdaynamicannotationsql.order;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order
public class order1 {
    public order1() {
        System.out.println("order1创建");
    }

    @PostConstruct
    public void test() {
        System.out.println("order1创建之后");
    }
}
