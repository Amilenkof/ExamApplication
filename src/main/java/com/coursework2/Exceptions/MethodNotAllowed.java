package com.coursework2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowed extends RuntimeException {
    public MethodNotAllowed() {
    }

    public MethodNotAllowed(String message) {
        super(message);
    }

    public MethodNotAllowed(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodNotAllowed(Throwable cause) {
        super(cause);
    }

    public MethodNotAllowed(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
