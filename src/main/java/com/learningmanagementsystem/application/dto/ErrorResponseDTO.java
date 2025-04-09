package com.learningmanagementsystem.application.dto;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponseDTO {
    private final int status;
    private final String error;
    private final String message;
    private final List<String> details;
    private final LocalDateTime timestamp;
}