package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.entity.Progress;
import com.learningmanagementsystem.domain.entity.ProgressKey;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.exception.EntityNotFoundException;
import com.learningmanagementsystem.domain.repository.CourseRepo;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import com.learningmanagementsystem.domain.repository.ProgressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserProgressUseCase {
    @Autowired
    MyUserRepo myUserRepo;
    @Autowired
    ProgressRepo progressRepo;
    @Autowired
    CourseRepo courseRepo;

    public Progress execute(int courseId) {
        Course course = courseRepo.findById((long) courseId).orElseThrow(
                () -> new EntityNotFoundException("Course", "id", courseId)
        );
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = myUserRepo.findByUsername(username);

        // Check enrollments first.
        Progress progress = progressRepo.findById(new ProgressKey((long) user.getId(), (long) courseId))
                .orElseThrow(
                        () -> new EntityNotFoundException("Progress", "id", courseId)
                );
        return progress;
    }
}
