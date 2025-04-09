package com.learningmanagementsystem.domain.exception;

import lombok.Getter;

@Getter
public class UseCaseException extends RuntimeException {
    private final String useCase;

    public UseCaseException(String useCase, String message) {
        super(message);
        this.useCase = useCase;
    }

    public UseCaseException(String useCase, String message, Throwable cause) {
        super(message, cause);
        this.useCase = useCase;
    }
}