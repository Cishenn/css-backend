package com.cishenn.ccs.exception;

public class WorkloadStatisticsException extends BaseException {
    public WorkloadStatisticsException (String message){
        super("WorkloadStatistics Part Error", message);
    }
}