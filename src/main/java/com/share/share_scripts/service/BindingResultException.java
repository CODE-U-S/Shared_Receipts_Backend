package com.share.share_scripts.service;

import com.share.share_scripts.exception.BadRequestException;
import com.share.share_scripts.exception.handler.ErrorCode;
import org.springframework.validation.BindingResult;

public class BindingResultException {
    /**
     * bad request 인지 확인 하는 메소드
     * @param bindingResult
     */
    protected void badRequestException(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) throw new BadRequestException(ErrorCode.BAD_REQUEST);
    }
}
