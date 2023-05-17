package com.coursework2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ArrayAlreadyHaveThisQuestion extends RuntimeException {

    public ArrayAlreadyHaveThisQuestion(String message) {
        super(message);
    }
}
