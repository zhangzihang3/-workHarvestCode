package com.zzh.mybatisplusdaynamicannotationsql.diyJsonData;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

/**
 * @author 张子行
 * @class
 */
@JsonSerialize(using = DivSerializer.class)
public class DivException extends BaseException {
    public DivException(ErrorMsg errorMsg, LocalDateTime date) {
        super(errorMsg, date);
    }
}
