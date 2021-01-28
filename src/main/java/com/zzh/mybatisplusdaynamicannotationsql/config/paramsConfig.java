package com.zzh.mybatisplusdaynamicannotationsql.config;

import com.zzh.mybatisplusdaynamicannotationsql.entity.Goods;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zzh
 * @class
 */
@Component
@Data
public class paramsConfig {
    @Value("${Good.name}")
    private String goodName;
    @Value("#{1+1}")
    private String jGoodPrice;
    @Value("${Good.price}")
    private String goodPrice;
    @Value("${Good.bad:null}")
    private String goodbad;
}
