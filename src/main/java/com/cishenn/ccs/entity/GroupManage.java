package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class GroupManage {

        private Integer groupId;//组号
        private String name;//组名
        private Integer number;//人数
        private Date createTime;
}