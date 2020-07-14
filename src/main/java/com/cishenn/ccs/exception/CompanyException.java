package com.cishenn.ccs.exception;

public class CompanyException extends BaseException{
    public CompanyException(String message){
        super("Company Part Error", message);
    }
}