package com.learningmanagementsystem.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequestDTO {
    private String title;

    private String description;

    private String category;

    private String status;

}

