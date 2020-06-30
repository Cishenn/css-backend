package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Session {
    private Integer sessionId;
    private Integer customerServiceId;
    private String visitorIp;
    private String visitorName;
    private Date createTime;
    private Date finishTime;
    private String channel;
    private Date evaluationTime;
    private String evaluation;
    private String evaluationDetail;
    private Date firstResponseTime;
    private Integer customerMsgNum;
    private Integer customerServiceMsgNum;
}
