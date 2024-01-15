package kr.co.gongma.gongma_admin_rest_api.exception;

import lombok.Getter;

@Getter
public class ApiException extends Exception {
    private String title;
    private String type;
    private int code;
    private String message;

    public ApiException(ErrorCode errorCode) {
        this.title = errorCode.getTitle();
        this.type = errorCode.getType();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
