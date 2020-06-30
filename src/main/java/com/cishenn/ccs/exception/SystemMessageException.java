package com.cishenn.ccs.exception;

public class SystemMessageException extends BaseException{
    public SystemMessageException(String message){
        super("SystemMessage Part Error", message);
    }
}

