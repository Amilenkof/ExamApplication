package com.coursework2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class ArrayIsNotContainsQuestion extends RuntimeException {
    public ArrayIsNotContainsQuestion(String s) {
    }
}
