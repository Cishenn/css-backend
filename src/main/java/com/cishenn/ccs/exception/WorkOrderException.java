package com.cishenn.ccs.exception;

public class WorkOrderException extends BaseException {
    public WorkOrderException(String message){
        super("WorkOrder Part Error", message);
    }
}