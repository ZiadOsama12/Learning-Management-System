package com.learningmanagementsystem.application.mappers;

import com.learningmanagementsystem.application.dto.CreateCourseRequestDTO;
import com.learningmanagementsystem.application.dto.CreateCourseResponseDTO;
import com.learningmanagementsystem.domain.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toEntity(CreateCourseRequestDTO request);

//    @Mapping(target = "id", ignore = true)
    CreateCourseResponseDTO toDTO(Course moduleEntity);
}
