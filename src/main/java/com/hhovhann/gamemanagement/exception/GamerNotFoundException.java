package com.hhovhann.gamemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static org.springframework.http.HttpStatus.*;

@ResponseStatus(NOT_FOUND)
public class GamerNotFoundException extends RuntimeException {
    @Serial
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