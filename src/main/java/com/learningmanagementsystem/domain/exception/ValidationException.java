package com.learningmanagementsystem.domain.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }


    public ValidationException(String message, Throwable cause, List<String> errors) {
        super(message, cause);
        this.errors = errors;
    }
}