package daw.dwes._6.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiExceptions.class)
    public ResponseEntity<ApiError> handleApiException(ApiExceptions ex) {
        HttpStatus status = (HttpStatus) ex.getStatusCode(); // Convertimos a HttpStatus

        ApiError error = new ApiError(
            LocalDateTime.now(),
            status.value(),
            ex.getReason(),
            status.getReasonPhrase()
        );
        return new ResponseEntity<>(error, status);
    }
}