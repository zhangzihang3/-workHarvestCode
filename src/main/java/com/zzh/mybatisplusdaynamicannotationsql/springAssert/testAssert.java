package com.zzh.mybatisplusdaynamicannotationsql.springAssert;

import com.zzh.mybatisplusdaynamicannotationsql.entity.Goods;
import org.springframework.util.Assert;

import java.util.ArrayList;

public class testAssert {
    public static void main(String[] args) {
        String text = "";
        Object object = null;
        Boolean btext = false;
        ArrayList<Integer> list = new ArrayList<>();
        if (text != null && "".equals(text)) {
            throw new IllegalArgumentException("字符不能为null，且至少包含一个非空格字符");
        }
        //list.add(1);
        //Assert.hasText(text,"字符不能为null，且至少包含一个非空格字符"); //String
        //Assert.hasLength(text,"字符不能为null，且字符长度不为0"); //String
        //Assert.notEmpty(list,"集合不能为空");
        //Assert.notNull(object,"对象不能为null"); //Object
        //Assert.isTrue(btext,"对象必须为true"); //布尔类型
        Assert.isInstanceOf(Object.class, new Goods(), "不能转换成Goods类型");
    }
}
