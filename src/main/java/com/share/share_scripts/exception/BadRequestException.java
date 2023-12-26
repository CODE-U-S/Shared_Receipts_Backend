package com.share.share_scripts.exception;

import com.share.share_scripts.exception.handler.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;

@Getter
@RequiredArgsConstructor
public class BadRequestException extends RuntimeException {
    private final ErrorCode errorCode;

    /**
     * bad request 인지 확인 하는 메소드
     * @param bindingResult
     */
    public static void badRequestException(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) throw new BadRequestException(ErrorCode.BAD_REQUEST);
    }
}
