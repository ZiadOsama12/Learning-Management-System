package com.learningmanagementsystem.application.service;

import com.learningmanagementsystem.domain.entity.Lesson;
import com.learningmanagementsystem.domain.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    LessonRepo lessonRepo;
    public Lesson getLessonById(long lessonId) {
        return lessonRepo.findById(lessonId).orElse(null);
    }
}
