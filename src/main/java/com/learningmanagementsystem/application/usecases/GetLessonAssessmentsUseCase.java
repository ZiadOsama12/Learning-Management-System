package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Assessment;
import com.learningmanagementsystem.domain.repository.AssessmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLessonAssessmentsUseCase {
    @Autowired
    private AssessmentRepo assessmentRepo;

    public List<Assessment> execute(Long id) {
        List<Assessment> assessments = assessmentRepo.getAssessmentsByLessonId(id);
        return assessments;
    }
}
