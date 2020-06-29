package com.cishenn.ccs.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{
    private String error="General Error";
    private Integer status;

    public BaseException(String message){
        super(message);
    }

    public BaseException(String error, String message){
        super(message);
        this.error=error;
    }
}
