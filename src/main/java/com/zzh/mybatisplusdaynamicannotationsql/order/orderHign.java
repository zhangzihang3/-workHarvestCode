package com.zzh.mybatisplusdaynamicannotationsql.order;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class orderHign {
    public orderHign() {
        System.out.println("orderHign创建");
    }

    @PostConstruct
    public void test() {
        System.out.println("orderHign创建之后");
    }
}
