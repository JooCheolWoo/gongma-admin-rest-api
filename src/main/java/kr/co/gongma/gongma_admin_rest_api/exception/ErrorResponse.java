package kr.co.gongma.gongma_admin_rest_api.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final Object error;

    public ErrorResponse(CustomException e) {
        this.error = new ErrorInfo(e.getTitle(), e.getType(), e.getCode(), e.getMessage());
    }

    private record ErrorInfo(String title, String type, int code, String message) {
    }
}
