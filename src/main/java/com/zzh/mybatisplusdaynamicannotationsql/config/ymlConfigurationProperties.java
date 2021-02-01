package com.zzh.mybatisplusdaynamicannotationsql.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author 张子行
 * @class 必须要有get、set方法
 * ignoreInvalidFields=true: 忽略绑定失败的值，只是为null
 * ignoreUnknownFields = false: yml配置文件中的字段，ymlConfigurationProperties中并没有配置，启动时会报错，提示此属性还未绑定
 */
@Component
@Data
@ConfigurationProperties(prefix = "a", ignoreInvalidFields = true)
public class ymlConfigurationProperties {
    private String name = "cName";
    private Integer price = 200;
    /**
     * 注入yml配置文件属性失败或者yml配置文件中此属性并没有赋值，那么默认值为false
     */
    private Boolean enable = false;
    private String unkonwn = null;
    private List<String> list = null;
    private Duration duration = Duration.ofSeconds(1);

    private DataSize dataSize = DataSize.ofMegabytes(1);
}
