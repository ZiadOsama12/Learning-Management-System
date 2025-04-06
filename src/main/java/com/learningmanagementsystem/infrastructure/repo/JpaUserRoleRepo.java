package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.UserRole;
import com.learningmanagementsystem.domain.entity.UserRoleId;
import com.learningmanagementsystem.domain.repository.IBaseRepo;
import com.learningmanagementsystem.domain.repository.UserRoleRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface JpaUserRoleRepo extends UserRoleRepo, JpaRepository<UserRole, UserRoleId> {
}
