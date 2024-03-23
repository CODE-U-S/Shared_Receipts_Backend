package com.share.share_scripts.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /**
     * 400 BAD_REQUEST : 잘못된 요청
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    /**
     * 404 NOT_FOUND : 정보를 찾을 수 없음.
     *
     * 1. POSTS : 게시글
     * 2. USERS : 사용자
     */
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글 정보를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자 정보를 찾을 수 없습니다."),
    RECEIPT_NOT_FOUND(HttpStatus.NOT_FOUND, "영수증의 정보를 찾을 수 없습니다."),
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "상품의 정보를 찾을 수 없습니다."),
    FOLLOW_NOT_FOUND(HttpStatus.NOT_FOUND, "팔로우한 정보를 찾을 수 없습니다"),


    /**
     * 405 METHOD_NOT_ALLOWED : 허용되지 않은 Request Method 호출
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메소드입니다."),

    /**
     * 409 ID_DUPLICATE : 중복된 아이디 요청
     */
    ID_DUPLICATE(HttpStatus.CONFLICT, "중복된 아이디입니다."),
    FOLLOW_DUPLICATE(HttpStatus.CONFLICT, "중복된 팔로우 신청입니다."),

    /**
     * 500 INTERNAL_SERVER_ERROR : 내부 서버 오류
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다.");

    private final HttpStatus status;
    private final String message;
}
