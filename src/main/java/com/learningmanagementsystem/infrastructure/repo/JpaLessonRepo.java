package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Lesson;
import com.learningmanagementsystem.domain.repository.LessonRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLessonRepo extends LessonRepo, JpaRepository<Lesson, Long> {
}
