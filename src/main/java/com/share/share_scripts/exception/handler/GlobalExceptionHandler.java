package com.share.share_scripts.exception.handler;

import com.share.share_scripts.exception.*;
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

    @ExceptionHandler(PostNotFoundException.class)
    protected ResponseEntity handlePostNotFoundException(PostNotFoundException e) {
        return ResponseEntity
                .status(ErrorCode.POST_NOT_FOUND.getStatus().value())
                .body(new ErrorResponse(ErrorCode.POST_NOT_FOUND));
    }

    @ExceptionHandler(ReceiptNotFoundException.class)
    protected ResponseEntity handleReceiptNotFoundException(ReceiptNotFoundException e) {
        return ResponseEntity
                .status(ErrorCode.RECEIPT_NOT_FOUND.getStatus().value())
                .body(new ErrorResponse(ErrorCode.RECEIPT_NOT_FOUND));
    }

    @ExceptionHandler(UserDuplicateException.class)
    protected ResponseEntity handleUserDuplicateException(UserDuplicateException e) {
        return ResponseEntity
                .status(ErrorCode.ID_DUPLICATE.getStatus().value())
                .body(new ErrorResponse(ErrorCode.ID_DUPLICATE));
    }

    @ExceptionHandler(FollowNotFoundException.class)
    protected ResponseEntity handleFollowNotFoundException(FollowNotFoundException e) {
        return ResponseEntity
                .status(ErrorCode.FOLLOW_NOT_FOUND.getStatus().value())
                .body(new ErrorResponse(ErrorCode.FOLLOW_NOT_FOUND));
    }

    @ExceptionHandler(FollowDuplicateException.class)
    protected ResponseEntity handleFollowDuplicateException(FollowDuplicateException e) {
        return ResponseEntity
                .status(ErrorCode.FOLLOW_DUPLICATE.getStatus().value())
                .body(new ErrorResponse(ErrorCode.FOLLOW_DUPLICATE));
    }
}