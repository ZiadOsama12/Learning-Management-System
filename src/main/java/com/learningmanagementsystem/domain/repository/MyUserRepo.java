package com.learningmanagementsystem.domain.repository;

import com.learningmanagementsystem.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepo extends IBaseRepo<Users, Long> {
    Users findByUsername(String username);
}
