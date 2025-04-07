package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Progress;
import com.learningmanagementsystem.domain.repository.ProgressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserProgressUseCase {
    @Autowired
    ProgressRepo progressRepo;

    public Progress execute(Progress progress) {
        return progressRepo.save(progress);
    }
}
