package com.share.share_scripts.exception.handler;

import com.share.share_scripts.exception.DuplicateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateException.class)
    protected ResponseEntity handleDuplicateException(DuplicateException e) {
        return ResponseEntity
                .status(e.getErrorCode().getStatus())
                .body(
                        new ErrorResponse(
                                e.getErrorCode().getStatus(),
                                e.getErrorCode().getMessage()
                        )
                );
    }
}