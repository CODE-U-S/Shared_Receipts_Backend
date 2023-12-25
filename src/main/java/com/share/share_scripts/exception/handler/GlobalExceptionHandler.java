package com.share.share_scripts.exception.handler;

import com.share.share_scripts.exception.BadRequestException;
import com.share.share_scripts.exception.DuplicateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity handleBadRequestException(BadRequestException e) {
        return ResponseEntity
                .status(ErrorCode.BAD_REQUEST.getStatus().value())
                .body(new ErrorResponse(ErrorCode.BAD_REQUEST));
    }

    @ExceptionHandler(DuplicateException.class)
    protected ResponseEntity handleDuplicateException(DuplicateException e) {
        return ResponseEntity
                .status(ErrorCode.ID_DUPLICATE.getStatus().value())
                .body(new ErrorResponse(ErrorCode.ID_DUPLICATE));
    }
}