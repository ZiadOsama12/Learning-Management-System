package com.learningmanagementsystem.domain.exception;

import lombok.Getter;

@Getter
public class BusinessRuleViolationException extends RuntimeException {
    private final String rule;
    public BusinessRuleViolationException(String message, String rule) {
        super(message);
        this.rule = rule;
    }
}
