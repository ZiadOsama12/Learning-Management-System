package com.learningmanagementsystem.domain.repository;

import com.learningmanagementsystem.domain.entity.Users;

import java.util.Optional;

public interface IBaseRepo<T> {
    T save(T object);
    Optional<T> findById(Long id);
//    T create(T object);
}
