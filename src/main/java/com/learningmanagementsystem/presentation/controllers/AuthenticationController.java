package com.learningmanagementsystem.presentation.controllers;

import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.application.service.MyUserDetailsService;
import com.learningmanagementsystem.application.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

    private MyUserDetailsService myUserDetailsService;

    private UserService userService;

    @Autowired
    public AuthenticationController(MyUserDetailsService myUserDetailsService, UserService userService) {
        this.myUserDetailsService = myUserDetailsService;
        this.userService = userService;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName()); // header =
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {

        return ResponseEntity.ok(userService.verify(user));
    }
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        userService.save(user);
        return user;
    }
    @PostMapping("/refresh_token")
    public ResponseEntity<?> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        return  ResponseEntity.ok(userService.refreshToken(request, response));
    }
}
