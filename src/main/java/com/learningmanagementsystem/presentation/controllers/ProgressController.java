package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.GetUserProgressUseCase;
import com.learningmanagementsystem.application.usecases.UpdateUserProgressUseCase;
import com.learningmanagementsystem.domain.entity.Progress;
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

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<?> getUserProgress(@PathVariable int courseId) {
        Progress progress = getUserProgressUseCase.execute(courseId);
        return ResponseEntity.ok(progress);
    }

    @PutMapping
    public ResponseEntity<?> updateUserProgress(@RequestBody Progress progress) {
        Progress updatedProgress = updateUserProgressUseCase.execute(progress);
        return ResponseEntity.ok(updatedProgress);
    }

}
