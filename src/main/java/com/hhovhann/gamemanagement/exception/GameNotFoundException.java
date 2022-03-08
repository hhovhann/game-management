package com.hhovhann.gamemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3796707547748245401L;

    public GameNotFoundException() {
        super();
    }

    public GameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameNotFoundException(String message) {
        super(message);
    }

    public GameNotFoundException(Throwable cause) {
        super(cause);
    }
}
