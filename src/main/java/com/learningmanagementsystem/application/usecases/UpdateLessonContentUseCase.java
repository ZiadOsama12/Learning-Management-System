package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Lesson;
import com.learningmanagementsystem.domain.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateLessonContentUseCase {
    @Autowired
    private LessonRepo lessonRepo;

    public Lesson execute(Lesson lesson) {
        return lessonRepo.save(lesson);
    }
}
