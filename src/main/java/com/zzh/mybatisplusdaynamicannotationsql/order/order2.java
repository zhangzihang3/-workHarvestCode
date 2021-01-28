package com.zzh.mybatisplusdaynamicannotationsql.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order
public class order2 {
    public order2() {
        System.out.println("order2创建");
    }

    @PostConstruct
    public void test() {
        System.out.println("order2创建之后");
    }
}
