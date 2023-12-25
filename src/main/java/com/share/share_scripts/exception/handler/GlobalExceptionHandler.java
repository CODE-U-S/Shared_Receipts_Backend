package com.share.share_scripts.exception.handler;

import com.share.share_scripts.exception.BadRequestException;
import com.share.share_scripts.exception.DuplicateException;
import com.share.share_scripts.exception.UserNotFoundException;
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

    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity
                .status(ErrorCode.USER_NOT_FOUND.getStatus().value())
                .body(new ErrorResponse(ErrorCode.USER_NOT_FOUND));
    }

    @ExceptionHandler(DuplicateException.class)
    protected ResponseEntity handleDuplicateException(DuplicateException e) {
        return ResponseEntity
                .status(ErrorCode.ID_DUPLICATE.getStatus().value())
                .body(new ErrorResponse(ErrorCode.ID_DUPLICATE));
    }
}