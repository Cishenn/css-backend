package com.cishenn.ccs.exception;

public class NoticeException extends BaseException {
    public NoticeException(String message){
        super("Notice Part Error", message);
    }
}
