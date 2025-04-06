package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.dto.AssignRoleRequestDTO;
import com.learningmanagementsystem.application.service.UserService;
import com.learningmanagementsystem.application.usecases.AssignRoleToUserUseCase;
import com.learningmanagementsystem.application.usecases.CreateCourseUseCase;
import com.learningmanagementsystem.application.usecases.GetCourseAssessmentsUseCase;
import com.learningmanagementsystem.domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    //    private CreateUserUseCase createCourseUseCase;
    private GetCourseAssessmentsUseCase getCourseAssessmentsUseCase;
    private AssignRoleToUserUseCase assignRoleToUserUseCase;

    @Autowired
    public UserController(CreateCourseUseCase createCourseUseCase, GetCourseAssessmentsUseCase getCourseAssessmentsUseCase, AssignRoleToUserUseCase assignRoleToUserUseCase, UserService userService) {
//        this.createCourseUseCase = createCourseUseCase;
        this.getCourseAssessmentsUseCase = getCourseAssessmentsUseCase;
        this.assignRoleToUserUseCase = assignRoleToUserUseCase;
        this.userService = userService;
    }

    //    @PostMapping
//    public ResponseEntity<?> createUser(CreateCourseUseCase createUser) {
//        return ResponseEntity.ok().build();
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        Users user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/assign-role")
    public ResponseEntity<?> assignRoleToUser(@RequestBody AssignRoleRequestDTO assignRoleRequestDTO) {
        Users user = assignRoleToUserUseCase.execute(assignRoleRequestDTO);
        return ResponseEntity.ok(user);
    }

}
