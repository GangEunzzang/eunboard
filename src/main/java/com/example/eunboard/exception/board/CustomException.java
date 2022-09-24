package gang.study.crud.exception.board;

import gang.study.crud.exception.ErrorCode;
import lombok.Getter;

@Getter
public class BoardException extends RuntimeException {

    private ErrorCode errorCode;

    public BoardException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
