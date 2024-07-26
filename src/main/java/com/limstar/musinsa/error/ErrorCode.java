package com.limstar.musinsa.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, 404,"해당하는 데이터를 찾을 수 없습니다."),
    ;


    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
