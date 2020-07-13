package com.cishenn.ccs.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SessionMsg {
    private Integer sessionMsgId;
    private Boolean fromVisitor;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;
    private String content;
    private Integer sessionId;
}
