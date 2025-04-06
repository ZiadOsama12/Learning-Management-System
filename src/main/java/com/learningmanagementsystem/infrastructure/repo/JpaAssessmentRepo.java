package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Assessment;
import com.learningmanagementsystem.domain.repository.AssessmentRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAssessmentRepo extends AssessmentRepo, JpaRepository<Assessment, Long> {
}
