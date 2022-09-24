package com.example.eunboard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    MEMBER_NOT_FOUND(404, "COMMON-ERR-404", "사용자를 찾을 수 없습니다"),
    MEMBER_NOT_AUTHORITY(500, "COMMON-ERR-500", "권한이 없습니다.");

    private int status;
    private String errorCode;
    private String message;
}
