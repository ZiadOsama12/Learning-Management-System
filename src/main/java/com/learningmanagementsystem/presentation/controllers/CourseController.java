package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.dto.CoursesResponseDTO;
import com.learningmanagementsystem.application.dto.CreateCourseRequestDTO;
import com.learningmanagementsystem.application.dto.CreateCourseResponseDTO;
import com.learningmanagementsystem.application.usecases.CreateCourseUseCase;
import com.learningmanagementsystem.application.usecases.GetLessonAssessmentsUseCase;
import com.learningmanagementsystem.application.usecases.GetCourseUseCase;
import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.exception.BusinessRuleViolationException;
import com.learningmanagementsystem.domain.exception.ValidationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CreateCourseUseCase createCourseUseCase;
    private GetCourseUseCase getCourseUseCase;
    private GetLessonAssessmentsUseCase getLessonAssessmentsUseCase;

    @Autowired
    public CourseController(CreateCourseUseCase createCourseUseCase, GetCourseUseCase getCourseUseCase, GetLessonAssessmentsUseCase getLessonAssessmentsUseCase) {
        this.createCourseUseCase = createCourseUseCase;
        this.getCourseUseCase = getCourseUseCase;
        this.getLessonAssessmentsUseCase = getLessonAssessmentsUseCase;
    }

    @PostMapping()
    public ResponseEntity<?> createCourse(@RequestBody @Valid CreateCourseRequestDTO course) {
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
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        Course course = getCourseUseCase.execute(id);
        return ResponseEntity.ok(course);
    }
    @GetMapping("")
    public ResponseEntity<?> getAllCourse(
            @RequestParam(value = "pageNo", defaultValue = "0") Optional<Integer> pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") Optional<Integer> pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id") Optional<String> sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc") Optional<String> sortDir
    ) {
        if (pageNo.isEmpty() || pageSize.isEmpty()) {
            throw new BusinessRuleViolationException("Missing required parameters: pageNo and pageSize","pageNo and pageSize are required");
        }

        if (pageNo.get() < 0 || pageSize.get() < 1) {
            throw new BusinessRuleViolationException("Invalid values: pageNo must be >= 0 and pageSize >= 1","");
        }

        CoursesResponseDTO courses = getCourseUseCase.execute(pageNo.get(), pageSize.get(),sortBy.get(), sortDir.get());
        return ResponseEntity.ok(courses);
    }


}
