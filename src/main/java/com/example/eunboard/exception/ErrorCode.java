package gang.study.crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(404, "COMMON-ERR-404", "없는 페이지 입니다."),
    INTER_SERVER_ERROR(500, "COMMON-ERR-500", "잘못된 접근입니다.");

    private int status;
    private String errorCode;
    private String message;
}
