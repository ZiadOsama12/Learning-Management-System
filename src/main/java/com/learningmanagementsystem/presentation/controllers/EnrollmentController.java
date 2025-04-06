package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.EnrollUserInCourseUseCase;
import com.learningmanagementsystem.domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    private EnrollUserInCourseUseCase enrollUserInCourseUseCase;

    @Autowired
    public EnrollmentController(EnrollUserInCourseUseCase enrollUseCase) {
        enrollUserInCourseUseCase = enrollUseCase;
    }

    @PostMapping("/courses/{courseId}")
    public ResponseEntity<?>enrollUser(@PathVariable long courseId) {
        Users user = enrollUserInCourseUseCase.execute(courseId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?>getUserEnrollments(){
        return ResponseEntity.ok().build();
    }
}
