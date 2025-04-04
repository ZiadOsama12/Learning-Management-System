package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.EnrollUserInCourseUseCase;
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

    @PostMapping
    public ResponseEntity<?>enrollUser() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?>getUserEnrollments(){
        return ResponseEntity.ok().build();
    }
}
