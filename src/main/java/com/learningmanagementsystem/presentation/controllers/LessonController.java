package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.application.service.LessonService;
import com.learningmanagementsystem.application.usecases.GetLessonAssessmentsUseCase;
import com.learningmanagementsystem.application.usecases.UpdateLessonContentUseCase;
import com.learningmanagementsystem.domain.entity.Assessment;
import com.learningmanagementsystem.domain.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {
    private UpdateLessonContentUseCase updateLessonContentUseCase;
    private GetLessonAssessmentsUseCase getLessonAssessmentsUseCase;
    private LessonService lessonService;
    @Autowired
    public LessonController(UpdateLessonContentUseCase updateLessonContentUseCase, GetLessonAssessmentsUseCase getLessonAssessmentsUseCase, LessonService lessonService) {
        this.updateLessonContentUseCase = updateLessonContentUseCase;
        this.getLessonAssessmentsUseCase = getLessonAssessmentsUseCase;
        this.lessonService = lessonService;
    }

    //    @PutMapping("{id}")
    @PutMapping()
    public ResponseEntity<?> updateLessonContent(@RequestBody Lesson lesson) {
        Lesson updatedLesson = updateLessonContentUseCase.execute(lesson);
        return ResponseEntity.ok(lesson);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getLessonById(@PathVariable("id") Long lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(lesson);
    }
    @GetMapping("/{id}/assessments")
    public ResponseEntity<?> getLessonAssessments(@PathVariable Long id) {
        List<Assessment> assessments = getLessonAssessmentsUseCase.execute(id);
        return ResponseEntity.ok(assessments);
    }
}
