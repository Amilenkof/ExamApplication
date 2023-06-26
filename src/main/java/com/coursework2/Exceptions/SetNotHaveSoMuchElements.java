package com.coursework2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SetNotHaveSoMuchElements extends RuntimeException {
    public SetNotHaveSoMuchElements(String message) {
        super(message);
    }
}
