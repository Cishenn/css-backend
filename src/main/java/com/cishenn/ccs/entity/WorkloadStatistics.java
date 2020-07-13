package com.cishenn.ccs.entity;

import lombok.Data;

@Data
public class WorkloadStatistics {
    private Integer id;
    private String nickName;
    private Integer totalMessageCount;
    private Integer totalSessionCount;
    private Integer totalEffectiveSessionCount;
    private Integer totalEndSessionCount;
    private Integer totalSessionTime;
}
