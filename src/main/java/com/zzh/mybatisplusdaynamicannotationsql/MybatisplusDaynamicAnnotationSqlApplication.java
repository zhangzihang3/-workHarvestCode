package com.zzh.mybatisplusdaynamicannotationsql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@MapperScan(basePackages = {"com.zzh.mybatisplusdaynamicannotationsql.mapper"})
@SpringBootApplication
@ComponentScan(basePackages = "com.zzh")
public class MybatisplusDaynamicAnnotationSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusDaynamicAnnotationSqlApplication.class, args);
    }

}
