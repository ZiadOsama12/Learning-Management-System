package com.learningmanagementsystem.application.dto;

import com.learningmanagementsystem.domain.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesResponseDTO {
    private List<CreateCourseResponseDTO> courses;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean hasNext;

}
