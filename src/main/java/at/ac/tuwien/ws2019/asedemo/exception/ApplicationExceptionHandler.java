package at.ac.tuwien.ws2019.asedemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ASENotFoundException.class)
    public ResponseEntity<?> notFoundException(final ASENotFoundException e) {
        return ResponseEntity.notFound().build();
    }

}
