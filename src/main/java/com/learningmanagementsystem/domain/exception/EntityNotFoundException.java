package com.learningmanagementsystem.domain.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private final String entityName;
    private final String key;
    private final Object value;

    public EntityNotFoundException(String entityName, String key, Object value) {
        super(entityName + " with " + key + " " + value + " not found");
//        super(String.format("%s with ID %d not found", entityName, id));
        this.entityName = entityName;
        this.key = key;
        this.value = value;
    }

    public EntityNotFoundException(String message, Throwable cause, String entityName, String key, Object value) {
        super(message, cause);
        this.entityName = entityName;
        this.key = key;
        this.value = value;
    }


}
