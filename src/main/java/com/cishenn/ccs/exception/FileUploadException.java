package com.cishenn.ccs.exception;

public class FileUploadException extends BaseException {
    public FileUploadException(String message) {
        super("文件上传失败", message);
    }

    public FileUploadException(String message, Throwable cause) {
        super("文件上传失败", message, cause);
    }
}