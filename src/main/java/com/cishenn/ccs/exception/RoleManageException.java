package com.cishenn.ccs.exception;

public class RoleManageException extends BaseException{
    public RoleManageException(String message){
        super("RoleManage Part Error", message);
    }
}
