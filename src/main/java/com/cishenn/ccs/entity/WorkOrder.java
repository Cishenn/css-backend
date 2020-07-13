package com.cishenn.ccs.entity;

import lombok.Data;

@Data
public class WorkOrder {
    private Integer id;
    private String type;
    private String title;
    private String orderDesc;
    private String attachments;
    private String cclist;
    private String priority;
    private String state;
    private Integer customerServiceGroupId;
    private Integer customerServiceId;
    private Integer customerId;
    private String channel;
}
