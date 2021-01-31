package com.zzh.mybatisplusdaynamicannotationsql.diyJsonData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar;

import java.time.LocalDateTime;

/**
 * @author 张子行
 * @class
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseException {
    private ErrorMsg errorMsg;
    private LocalDateTime date;
}
