package com.nocountry.S12G15.exception;

public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException() {
    }

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
