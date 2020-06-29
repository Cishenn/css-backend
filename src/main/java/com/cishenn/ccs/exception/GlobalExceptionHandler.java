package com.cishenn.ccs.exception;

import com.cishenn.ccs.exception.BaseException;
import com.cishenn.ccs.entity.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 BaseException（以及其子类）并返回对应的错误响应
     * 剩余的异常由 Spring Boot 处理
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getClass().getName() + ": " + e.getMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(new Date());
        errorResponse.setException(e.getClass().getName());
        errorResponse.setStatus(e.getStatus());
        errorResponse.setError(e.getError());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }
}