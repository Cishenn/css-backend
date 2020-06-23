package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Tag {
    private int id;
    private String name;
    private String desc;
    private int type;
    private int creator_id;
    private Date create_time;
}
