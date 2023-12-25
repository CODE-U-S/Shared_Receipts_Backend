package com.share.share_scripts.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ID_DUPLICATE(HttpStatus.CONFLICT, "중복된 아이디입니다.");

    private final HttpStatus status;
    private final String message;
}
