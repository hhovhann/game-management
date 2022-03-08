package com.hhovhann.gamemanagement.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class GamerValidationException extends RuntimeException {

    private static final long serialVersionUID = 8784897209820125690L;

    public GamerValidationException() {
        super();
    }

    public GamerValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public GamerValidationException(String message) {
        super(message);
    }

    public GamerValidationException(Throwable cause) {
        super(cause);
    }
}