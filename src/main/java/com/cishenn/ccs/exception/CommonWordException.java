package com.cishenn.ccs.exception;

public class CommonWordException extends BaseException{
    public CommonWordException(String message){
        super("CommonWord Part Error", message);
    }
}
