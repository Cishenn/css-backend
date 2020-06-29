package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private String state;
    private String visitorName;
    private String realName;
    private String phone;
    private String email;
    private String company;
    private String address;
    private String level;
    private String channel;
    private Integer tagsId;
    private String remark;
    private Integer customerServiceId;
    private Date lastedLoginTime;
}
