package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.dto.CreateCourseRequestDTO;
import com.learningmanagementsystem.application.dto.CreateCourseResponseDTO;
import com.learningmanagementsystem.application.usecases.CreateCourseUseCase;
import com.learningmanagementsystem.application.usecases.GetCourseAssessmentsUseCase;
import com.learningmanagementsystem.application.usecases.GetCourseByIdUseCase;
import com.learningmanagementsystem.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CreateCourseUseCase createCourseUseCase;
    private GetCourseByIdUseCase getCourseByIdUseCase;
    private GetCourseAssessmentsUseCase getCourseAssessmentsUseCase;

    @Autowired
    public CourseController(CreateCourseUseCase createCourseUseCase, GetCourseByIdUseCase getCourseByIdUseCase, GetCourseAssessmentsUseCase getCourseAssessmentsUseCase) {
        this.createCourseUseCase = createCourseUseCase;
        this.getCourseByIdUseCase = getCourseByIdUseCase;
        this.getCourseAssessmentsUseCase = getCourseAssessmentsUseCase;
    }

    @PostMapping()
    public ResponseEntity<?> createCourse(@RequestBody CreateCourseRequestDTO course) {
        System.out.println("Create Course Request---------------------------");
        System.out.println(course);

        CreateCourseResponseDTO createCourseResponseDTO = createCourseUseCase.execute(course);
//        return ResponseEntity.ok(course);
        return ResponseEntity.ok(createCourseResponseDTO);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> testPost(@RequestBody CreateCourseRequestDTO course) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/assessments")
    public ResponseEntity<?> getCourseAssessments() {
        return ResponseEntity.ok().build();
    }
}
