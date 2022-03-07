package com.hhovhann.gamemanagement.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class GameValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -864467961952470818L;

    public GameValidationException() {
        super();
    }

    public GameValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameValidationException(String message) {
        super(message);
    }

    public GameValidationException(Throwable cause) {
        super(cause);
    }
}
