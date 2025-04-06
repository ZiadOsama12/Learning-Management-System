package com.learningmanagementsystem.domain.repository;

import com.learningmanagementsystem.domain.entity.Enrollment;
import com.learningmanagementsystem.domain.entity.EnrollmentKey;

public interface EnrollmentRepo extends IBaseRepo<Enrollment, EnrollmentKey> {
    boolean existsById(EnrollmentKey id);
}
