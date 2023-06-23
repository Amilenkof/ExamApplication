package com.coursework2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class SetAlreadyHaveThisQuestion extends RuntimeException {

    public SetAlreadyHaveThisQuestion(String message) {
        super(message);
    }
}
