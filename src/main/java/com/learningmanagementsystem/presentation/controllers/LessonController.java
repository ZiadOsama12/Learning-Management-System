package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.UpdateLessonContentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {
    private UpdateLessonContentUseCase updateLessonContentUseCase;

    @Autowired
    public LessonController(UpdateLessonContentUseCase updateLessonContentUseCase) {
        this.updateLessonContentUseCase = updateLessonContentUseCase;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateLessonContent(){
        return ResponseEntity.ok().build();
    }
}
