package com.usuarios.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResuorceNotFoundException extends RuntimeException {

    public ResuorceNotFoundException(String message) {
        super(message);
    }
}
