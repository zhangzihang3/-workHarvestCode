package com.zzh.mybatisplusdaynamicannotationsql.diyJsonData;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author 张子行
 * @class
 */
public class DivSerializer extends StdSerializer<DivException> {
    /**
     * @method 固定代码，原理搞不清
     */
    protected DivSerializer() {
        super(DivException.class);
    }
    /**
     * @method
     * @param DivException e:干涉前的对象
     * @param JsonGenerator jsonGenerator: json生成器，指定干涉后的json对象
     */
    @Override
    public void serialize(DivException e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("date", e.getDate());
        jsonGenerator.writeObjectField("ErrorMsg", e.getErrorMsg().getMsg());
        jsonGenerator.writeEndObject();
    }
}
