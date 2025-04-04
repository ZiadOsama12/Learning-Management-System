package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.GetUserProgressUseCase;
import com.learningmanagementsystem.application.usecases.UpdateUserProgressUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/progress")
public class ProgressController {
    private GetUserProgressUseCase getUserProgressUseCase;
    private UpdateUserProgressUseCase updateUserProgressUseCase;

    @Autowired
    public ProgressController(GetUserProgressUseCase getUserProgressUseCase, UpdateUserProgressUseCase updateUserProgressUseCase) {
        this.getUserProgressUseCase = getUserProgressUseCase;
        this.updateUserProgressUseCase = updateUserProgressUseCase;
    }

    @GetMapping()
    public ResponseEntity<?> getUserProgress(){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateUserProgress(){
        return ResponseEntity.ok().build();
    }

}
