package com.cishenn.ccs.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SessionMsg {
    private int id;
    private String msgSenderId;
    private String msgReceiverId;
    private Session session;
    private String msgSenderName;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime ;
}

