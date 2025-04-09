package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.exception.EntityNotFoundException;
import com.learningmanagementsystem.domain.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetCourseUseCase {
    @Autowired
    CourseRepo courseRepo;

    public Course execute(Long id) {
        Course course = courseRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Course", "id", id)
        );

        return course;
    }
    public List<Course> execute() {
        List<Course> courses = courseRepo.findAll();

        return courses;
    }
}
