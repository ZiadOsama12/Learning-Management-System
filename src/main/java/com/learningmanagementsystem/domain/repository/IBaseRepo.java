package com.learningmanagementsystem.domain.repository;

import com.learningmanagementsystem.domain.entity.EnrollmentKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IBaseRepo<T, ID> {
    T save(T object);
    Optional<T> findById(ID id);
    Page<T> findAll(Pageable pageable);
    boolean existsById(ID id);

//    boolean existsById(T id);
//    void saveAll(Set<T> objects);
//    T create(T object);
}
