package com.cishenn.ccs.entity;

import lombok.Data;

@Data
public class ViewStatistics {
    private Integer id;
    private String type;
    private Integer pageView;
    private Integer visitorNum;
    private Integer visitorCount;
    private Integer averagePageTime;

}
