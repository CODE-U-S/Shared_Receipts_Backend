package com.share.share_scripts.exception.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final int status;
    private final String message;

    public ErrorResponse (int status, String message) {
        this.status = status;
        this.message = message;
    }
}
