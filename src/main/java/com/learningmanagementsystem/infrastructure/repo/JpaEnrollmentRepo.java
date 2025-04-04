package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Enrollment;
import com.learningmanagementsystem.domain.repository.EnrollmentRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEnrollmentRepo extends EnrollmentRepo, JpaRepository<Enrollment, Long> {
}
