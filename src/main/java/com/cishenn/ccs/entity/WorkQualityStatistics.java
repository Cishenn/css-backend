package com.cishenn.ccs.entity;

import lombok.Data;

@Data
public class WorkQualityStatistics {
    private Integer id;
    private String nickName;
    private Integer effectiveSessionCount;
    private Integer resolved;
    private Integer unsolved;
    private Integer goodReview;
    private Integer mediumReview;
    private Integer badReview;
    private Integer noReview;
    private Integer firstAverageTime;
    private Integer averageTime;
}
