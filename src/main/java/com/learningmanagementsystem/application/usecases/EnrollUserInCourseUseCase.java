package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.entity.Enrollment;
import com.learningmanagementsystem.domain.entity.EnrollmentKey;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.repository.CourseRepo;
import com.learningmanagementsystem.domain.repository.EnrollmentRepo;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollUserInCourseUseCase {
    @Autowired
    private MyUserRepo userRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Transactional
    public Users execute(long courseId) {
        // Get the authenticated user from SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Users user = userRepo.findByUsername(username);

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        EnrollmentKey enrollmentId = new EnrollmentKey( user.getId(), courseId);
        if (enrollmentRepo.existsById(enrollmentId)) {
            throw new RuntimeException("User is already enrolled in this course");
        }


        Enrollment enrollment = new Enrollment(enrollmentId, user, course, "active");

        // Update the relationship
//        user.addCourse(enrollment); // error duplicate object in same hibernate session


//        return enrollmentRepository.save(enrollment);
        enrollmentRepo.save(enrollment);
        return user;
    }
}
