package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class SystemMessage {
    private Integer id;
    private String title;
    private Date createTime;
    private String content;

}
