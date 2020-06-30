package com.cishenn.ccs.exception;

public class WorkOrderReplyException extends BaseException{
    public WorkOrderReplyException(String message){
        super("WorkOrderReply Part Error", message);
    }
}
