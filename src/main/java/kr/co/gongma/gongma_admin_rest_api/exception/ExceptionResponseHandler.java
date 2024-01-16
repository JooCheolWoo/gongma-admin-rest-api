package kr.co.gongma.gongma_admin_rest_api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("kr.co.gongma.gongma_admin_rest_api") // 모든 controller 에 대한 예외를 잡아서 처리
public class ExceptionResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(ExceptionResponseHandler.class);

    @ExceptionHandler({CustomException.class}) // 해당 Bean 내에서 발생하는 예외를 잡아서 하나의 메서드에서 처리
    public ResponseEntity<ErrorResponse> apiException(CustomException e) {
        logger.error("{}({} : {}) - {}", e.getTitle(), e.getType(), e.getCode(), e.getMessage());
        ErrorResponse response = new ErrorResponse(e);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> validException(MethodArgumentNotValidException e) {
        CustomException exception = CustomException.builder()
                        .title("Validation 오류")
                        .type("MethodArgumentNotValidException")
                        .code(e.getStatusCode().value())
                        .message(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                        .build();
        logger.error("{}({} : {}) - {}", exception.getTitle(), exception.getType(), exception.getCode(), exception.getMessage());
        ErrorResponse response = new ErrorResponse(exception);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
