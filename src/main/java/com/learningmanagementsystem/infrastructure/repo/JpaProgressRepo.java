package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Progress;
import com.learningmanagementsystem.domain.entity.ProgressKey;
import com.learningmanagementsystem.domain.repository.ProgressRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProgressRepo extends ProgressRepo, JpaRepository<Progress, ProgressKey> {
}
