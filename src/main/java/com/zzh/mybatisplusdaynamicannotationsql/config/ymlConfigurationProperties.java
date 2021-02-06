package com.zzh.mybatisplusdaynamicannotationsql.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

/**
 * @author 张子行
 * @class 必须要有get、set方法
 * ignoreInvalidFields=true: 忽略绑定失败的值，只是为null
 * ignoreUnknownFields = false: yml配置文件中的字段，ymlConfigurationProperties中并没有配置，启动时会报错，提示此属性还未绑定
 */
@Slf4j
@Component
@Data
//yml或者properties文件中存在 key：enAble value：enAble的键值对，此配置文件才会生效
@ConditionalOnProperty(name = "enAble", havingValue = "enAble")
//绑定前缀为a的属性，忽略绑定失败的属性
@ConfigurationProperties(prefix = "a", ignoreInvalidFields = true)
public class ymlConfigurationProperties {
    private String name = "cName";
    private Integer price = 200;
    /**
     * 注入yml配置文件属性失败或者yml配置文件中此属性并没有赋值，那么默认值为false
     */
    private Boolean enable = false;
    private String unkonwn = null;
    /**
     * 绑定list类型
     */
    private List<String> list = null;
    /**
     * 绑定Duration类型
     */
    private Duration duration = Duration.ofSeconds(1);
    /**
     * 绑定DataSize类型
     */
    private DataSize dataSize = DataSize.ofMegabytes(1);
    /**
     * 绑定map类型
     */
    Map<String, String> map;

    /**
     * ioc容器中没有此bean（testBean），onMissTestBean才会注入。
     */
    @Bean
    @ConditionalOnMissingBean(testBean.class)
    public void onMissTestBean() {
        System.out.println("ConditionalOnMissingBean注解生效：");
    }
}
