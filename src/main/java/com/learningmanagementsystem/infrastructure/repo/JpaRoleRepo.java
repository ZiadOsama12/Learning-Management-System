package com.learningmanagementsystem.infrastructure.repo;

import com.learningmanagementsystem.domain.entity.Role;
import com.learningmanagementsystem.domain.repository.RoleRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepo extends RoleRepo, JpaRepository<Role, Long> {
}
