package com.learningmanagementsystem.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IBaseRepo<T, ID> {
    T save(T object);
    Optional<T> findById(ID id);
//    boolean existsById(T id);
//    void saveAll(Set<T> objects);
//    T create(T object);
}
