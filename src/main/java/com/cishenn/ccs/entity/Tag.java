package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Tag {
    private Integer creatorId;
    private String name;
    private String color;
    private String type;
    private Integer usedTimes;
    private Date createTime;

    private String description;
}
