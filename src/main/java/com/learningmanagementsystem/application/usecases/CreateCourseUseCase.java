package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.application.dto.CreateCourseRequestDTO;
import com.learningmanagementsystem.application.dto.CreateCourseResponseDTO;
import com.learningmanagementsystem.application.mappers.CourseMapper;
import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.exception.EntityNotFoundException;
import com.learningmanagementsystem.domain.repository.CourseRepo;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    MyUserRepo myUserRepo;
    public CreateCourseResponseDTO execute(CreateCourseRequestDTO courseRequestDTO) {

        Course course = courseMapper.toEntity(courseRequestDTO);
        // Get current username from security context
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // Fetch full user entity
        Users instructor = myUserRepo.findByUsername(username);
        if(instructor == null) {
            throw new EntityNotFoundException("User", "username", username);
        }
        course.setInstructor(instructor);
        System.out.println(course);

        courseRepo.save(course);
        CreateCourseResponseDTO createCourseResponseDTO = courseMapper.toDTO(course);
        return createCourseResponseDTO;
    }
}
