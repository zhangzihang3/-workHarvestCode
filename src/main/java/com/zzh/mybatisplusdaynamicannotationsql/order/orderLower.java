package com.zzh.mybatisplusdaynamicannotationsql.order;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class orderLower {
    public orderLower() {
        System.out.println("orderLower创建");
    }

    @PostConstruct
    public void test() {
        System.out.println("orderLower创建之后");
    }
}
