package com.learningmanagementsystem.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequestDTO {
    @NotBlank
    private String title;
    @Size(min = 1, max = 100)
    private String description;
    private String category;

    private String status;

}

