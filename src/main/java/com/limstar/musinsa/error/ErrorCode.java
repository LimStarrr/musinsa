package com.limstar.musinsa.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한이 유효하지 않습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 데이터를 찾을 수 없습니다."),
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),
    ;


    private final HttpStatus httpStatus;
    private final String message;
}
