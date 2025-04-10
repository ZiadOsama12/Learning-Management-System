package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.application.dto.CoursesResponseDTO;
import com.learningmanagementsystem.application.dto.CreateCourseResponseDTO;
import com.learningmanagementsystem.application.mappers.CourseMapper;
import com.learningmanagementsystem.domain.entity.Course;
import com.learningmanagementsystem.domain.exception.EntityNotFoundException;
import com.learningmanagementsystem.domain.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetCourseUseCase {
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    CourseMapper courseMapper;

    public Course execute(Long id) {
        Course course = courseRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Course", "id", id)
        );

        return course;
    }

    public CoursesResponseDTO execute(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC,sortBy)
                : Sort.by(Sort.Direction.DESC, sortBy);

        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Course> courses = courseRepo.findAll(pageable);
        List<Course> courseList = courses.getContent();

        List<CreateCourseResponseDTO> createCourseResponseDTO = courseList.stream().map (
                course -> courseMapper.toDTO(course)).collect(Collectors.toList());


        CoursesResponseDTO coursesResponseDTO = new CoursesResponseDTO();
        coursesResponseDTO.setCourses(createCourseResponseDTO);
        coursesResponseDTO.setPageNo(pageNo);
        coursesResponseDTO.setPageSize(pageSize);
        coursesResponseDTO.setTotalElements(courses.getTotalElements());
        coursesResponseDTO.setTotalPages(courses.getTotalPages());
        coursesResponseDTO.setHasNext(courses.hasNext());
        return coursesResponseDTO;
    }
}
