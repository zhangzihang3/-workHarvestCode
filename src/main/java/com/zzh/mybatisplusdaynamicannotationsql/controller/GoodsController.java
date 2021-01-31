package com.zzh.mybatisplusdaynamicannotationsql.controller;


import com.zzh.mybatisplusdaynamicannotationsql.diyJsonData.DivException;
import com.zzh.mybatisplusdaynamicannotationsql.diyJsonData.ErrorMsg;
import com.zzh.mybatisplusdaynamicannotationsql.diyJsonData.money;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author 张子行
 * @class
 */
@RestController
public class GoodsController {
    @GetMapping("/testMoney")
    public money test() {
        money money = new money(100, LocalDateTime.now(), null, "zzh");
        return money;
    }

    @GetMapping("/testDivException")
    public DivException b() {
        DivException divException = new DivException(new ErrorMsg(100, "error"), LocalDateTime.now());
        return divException;
    }
}

