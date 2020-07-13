package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Servicer {
    private String phone;
    private String password;
    private String state;
    private String avatar;
    private String email;
    private String nickName;
    private String realName;
    private String servicerPhone;
    private Integer customerServiceId;
    private Integer totalOnlineTime;
    private Date onlineTimeBegin;
    private Date onlineTimeEnd;
    private Integer dialogCount;
    private Integer msgCount;
    private String servicerGroup;
    private String servicerRole;
}
