package sit.int204.backend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse er = new ErrorResponse(
                LocalDateTime.now().toString(),                     // timestamp
                HttpStatus.NOT_FOUND.value(),                       // status
                HttpStatus.NOT_FOUND.getReasonPhrase(),             // error
                ex.getMessage()                                     // message
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

}


