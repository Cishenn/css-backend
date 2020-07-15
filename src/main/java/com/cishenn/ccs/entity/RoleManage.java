package com.cishenn.ccs.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class RoleManage {
    private Integer roleId;
    private String roleName;
    private Integer roleCount;
    private Date createTime;
    private String roleDesc;
    private String power;

}
