package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.AssignRoleToUserUseCase;
import com.learningmanagementsystem.application.usecases.CreateCourseUseCase;
import com.learningmanagementsystem.application.usecases.GetCourseAssessmentsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    //    private CreateUserUseCase createCourseUseCase;
    private GetCourseAssessmentsUseCase getCourseAssessmentsUseCase;
    private AssignRoleToUserUseCase assignRoleToUserUseCase;

    @Autowired
    public UserController(CreateCourseUseCase createCourseUseCase, GetCourseAssessmentsUseCase getCourseAssessmentsUseCase, AssignRoleToUserUseCase assignRoleToUserUseCase) {
//        this.createCourseUseCase = createCourseUseCase;
        this.getCourseAssessmentsUseCase = getCourseAssessmentsUseCase;
        this.assignRoleToUserUseCase = assignRoleToUserUseCase;
    }

    //    @PostMapping
//    public ResponseEntity<?> createUser(CreateCourseUseCase createUser) {
//        return ResponseEntity.ok().build();
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<?> assignRoleToUser() {
        return ResponseEntity.ok().build();
    }

}
