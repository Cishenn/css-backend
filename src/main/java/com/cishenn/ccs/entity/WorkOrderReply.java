package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class WorkOrderReply {
    private Integer workOrderId;
    private Integer servicerId;//此字段与杨老板组命名不同
    private Date replyTime;
    private String content;
}
