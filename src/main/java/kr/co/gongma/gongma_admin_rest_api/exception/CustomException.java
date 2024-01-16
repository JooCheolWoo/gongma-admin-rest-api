package kr.co.gongma.gongma_admin_rest_api.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CustomException extends Exception {
    private final String title;
    private final String type;
    private final int code;
    private final String message;

    @Builder
    public CustomException(String title, String type, int code, String message) {
        this.title = title;
        this.type = type;
        this.code = code;
        this.message = message;
    }

    public CustomException(ErrorCode errorCode) {
        this.title = errorCode.getTitle();
        this.type = errorCode.getType();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
