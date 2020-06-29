package com.cishenn.ccs.exception;

public class CustomerException extends BaseException{
    public CustomerException(String message){
        super("Customer Part Error", message);
    }
}
