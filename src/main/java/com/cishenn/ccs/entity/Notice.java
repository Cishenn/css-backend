package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer id;
    private String title;
    private String content;
    private Integer creatorId;
    private Date createTime;
    private Integer type;
}
