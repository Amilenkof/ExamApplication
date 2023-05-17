package com.coursework2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ArrayIsEmptyException extends RuntimeException {
    public ArrayIsEmptyException(String message) {
        super(message);
    }
}
