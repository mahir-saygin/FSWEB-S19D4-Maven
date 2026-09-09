package com.workintech.s19d1.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {

    private final String message;
    private final int status;
    private final LocalDateTime dateTime;

    public ExceptionResponse(String message, int status, LocalDateTime dateTime) {
        this.message = message;
        this.status = status;
        this.dateTime = dateTime;
    }
}