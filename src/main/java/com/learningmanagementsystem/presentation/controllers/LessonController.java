package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.usecases.GetLessonAssessmentsUseCase;
import com.learningmanagementsystem.application.usecases.UpdateLessonContentUseCase;
import com.learningmanagementsystem.domain.entity.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {
    private UpdateLessonContentUseCase updateLessonContentUseCase;
    private GetLessonAssessmentsUseCase getLessonAssessmentsUseCase;
    @Autowired
    public LessonController(UpdateLessonContentUseCase updateLessonContentUseCase, GetLessonAssessmentsUseCase getLessonAssessmentsUseCase) {
        this.updateLessonContentUseCase = updateLessonContentUseCase;
        this.getLessonAssessmentsUseCase = getLessonAssessmentsUseCase;
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateLessonContent(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/assessments")
    public ResponseEntity<?> getLessonAssessments(@PathVariable Long id) {
        List<Assessment> assessments = getLessonAssessmentsUseCase.execute(id);
        return ResponseEntity.ok(assessments);
    }
}
