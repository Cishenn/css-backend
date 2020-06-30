package com.cishenn.ccs.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorResponse {
    private Date timestamp;
    private String exception;
    private Integer status;
    private String error;
    private String message;
}
