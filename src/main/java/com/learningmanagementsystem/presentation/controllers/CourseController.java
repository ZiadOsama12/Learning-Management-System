package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.dto.CreateCourseRequestDTO;
import com.learningmanagementsystem.application.dto.CreateCourseResponseDTO;
import com.learningmanagementsystem.application.usecases.CreateCourseUseCase;
import com.learningmanagementsystem.application.usecases.GetLessonAssessmentsUseCase;
import com.learningmanagementsystem.application.usecases.GetCourseUseCase;
import com.learningmanagementsystem.domain.entity.Course;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> getAllCourse() {
        List<Course> courses = getCourseUseCase.execute();
        return ResponseEntity.ok(courses);
    }

}
