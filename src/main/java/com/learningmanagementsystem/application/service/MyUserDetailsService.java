package com.learningmanagementsystem.application.service;

import com.learningmanagementsystem.domain.entity.UserPrinciple;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService { // Iam implementing the UserDetailsService Now

    private MyUserRepo userRepo;


    @Autowired
    public MyUserDetailsService(MyUserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("user not found");
        }
        return new UserPrinciple(user);
    }


}
