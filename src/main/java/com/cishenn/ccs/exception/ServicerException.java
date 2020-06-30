package com.cishenn.ccs.exception;

public class ServicerException extends BaseException{
    public ServicerException(String message){
        super("Servicer Part Error", message);
    }
}
