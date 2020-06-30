package com.cishenn.ccs.entity;
import lombok.Data;

@Data
public class AttendanceStats {
    private Integer id;
    private String nickName;
    private Integer loginTime;
    private Integer freeTime;
    private Integer busyTime;
    private Integer onlineTime;
    private Integer offlineTime;
}
