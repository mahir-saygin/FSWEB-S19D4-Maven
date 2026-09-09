package com.workintech.s19d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse> handleApiException(ApiException ex) {
        ExceptionResponse response = new ExceptionResponse(
                ex.getMessage(),
                ex.getHttpStatus().value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException ex) {
        ExceptionResponse response = new ExceptionResponse(
                "General Exception occurred",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}