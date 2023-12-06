package com.nocountry.S12G15.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.time.LocalDateTime;

@Setter
@Getter
public class GenericException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timeStamp;
    private final int status;

    public GenericException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = LocalDateTime.now();
        this.status = httpStatus.value();
    }
}
