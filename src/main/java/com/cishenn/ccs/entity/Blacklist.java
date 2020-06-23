package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;
/**
 * @Data 就是使用lombok 简化编程
 * lombok 就是省了 getter() setter()等等
 */

@Data
public class Blacklist {
    private int id;
    private String reason;
    private Date time;
    private int cid;
    private int sid;
    private Date create_time;


}
