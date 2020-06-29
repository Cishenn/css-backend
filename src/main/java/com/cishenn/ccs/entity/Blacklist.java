package com.cishenn.ccs.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class Blacklist {
    private Integer servicerId;
    private Integer customerId;
    private String reason;
    private String source;

    //DataTimeFormat 对入参进行解析
    @DateTimeFormat(pattern = "yyyy-MM--dd")
    private Date time;
}
