package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.repository.CourseRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCourseRepo extends CourseRepo, JpaRepository<Course, Long> {
}
