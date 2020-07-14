package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Company {
    private String name;
    private String account;
    private String ID;
    private String industry;
    private String logo;
    private String teamScale;
    private String contactName;
    private Integer phone;
    private String address;
    private String remark;
}