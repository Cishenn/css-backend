package com.cishenn.ccs.exception;

public class AttendanceStatsException extends BaseException {
    public AttendanceStatsException(String message){
        super("AttendanceStats Part Error", message);
    }
}

