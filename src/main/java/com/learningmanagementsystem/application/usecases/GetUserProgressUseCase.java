package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.domain.entity.Progress;
import com.learningmanagementsystem.domain.entity.ProgressKey;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import com.learningmanagementsystem.domain.repository.ProgressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserProgressUseCase {
    @Autowired
    MyUserRepo myUserRepo;
    @Autowired
    ProgressRepo progressRepo;

    public Progress execute(int courseId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = myUserRepo.findByUsername(username);
        System.out.println("IDDDDDDD " + user.getId());
        Progress progress = progressRepo.findById(new ProgressKey((long) user.getId(), (long) courseId)).orElse(null);
        return progress;
    }
}
