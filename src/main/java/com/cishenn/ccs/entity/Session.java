package com.cishenn.ccs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Session {
    private  int id;

    private  Servicer cs;
    private String visitorIp;
    private String visitorName;
    private String visitorId;
    private String channel;

    private int customerMsgNum;
    private int customerServiceMsgNum;

    private int evaluation;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date evaluationTime;
    private String evaluationDetail;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date firstResponeTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    private String content;//最新的消息
}
