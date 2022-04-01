package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String cause) {
        super(cause);
    }
}
