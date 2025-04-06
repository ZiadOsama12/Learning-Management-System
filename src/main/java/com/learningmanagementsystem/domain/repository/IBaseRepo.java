package com.learningmanagementsystem.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IBaseRepo<T> {
    T save(T object);
    Optional<T> findById(Long id);
//    void saveAll(Set<T> objects);
//    T create(T object);
}
