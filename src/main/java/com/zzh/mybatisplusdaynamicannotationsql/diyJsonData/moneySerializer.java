package com.zzh.mybatisplusdaynamicannotationsql.diyJsonData;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zzh.mybatisplusdaynamicannotationsql.diyJsonData.money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * 自定义序列化逻辑
 */
/**
 * @author 张子行
 * @class
 */
@JsonComponent
public class moneySerializer extends StdSerializer<money> {
    protected moneySerializer() {
        super(money.class);
    }

    /**
     * 序列化逻辑，只取出Money中的amount
     */
    @Override
    public void serialize(money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        System.out.println(money);
        jsonGenerator.writeObjectField("amount", money.getAmount());
        jsonGenerator.writeObjectField("date", money.getDate());
        jsonGenerator.writeObjectField("unit", money.getUnit());
        jsonGenerator.writeObjectField("name", money.getName());
        jsonGenerator.writeEndObject();
    }
}