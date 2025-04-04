package com.learningmanagementsystem.infrastructure.repo;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMyUserRepo extends MyUserRepo, JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
