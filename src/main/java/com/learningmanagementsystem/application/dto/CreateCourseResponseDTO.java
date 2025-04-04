package com.learningmanagementsystem.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseResponseDTO {

    private Integer id;

    private String title;

    private String description;

    private String category;

    private String status;

}
