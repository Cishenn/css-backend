package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class VisitorInfo {
    private String ip;
    private String visitorName;
    private String terminal;
    private String browser;
    private String screenSize;
    private String device;
    private Integer customerServiceId;
    private String state;
    private Integer visitDuration;
}
