package com.hhovhann.gamemanagement.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class GamerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4905312929038408201L;

    public GamerNotFoundException() {
        super();
    }

    public GamerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GamerNotFoundException(String message) {
        super(message);
    }

    public GamerNotFoundException(Throwable cause) {
        super(cause);
    }
}