package com.learningmanagementsystem.application.service;

import com.learningmanagementsystem.application.dto.JwtResponseDTO;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private MyUserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private JWTService jwtService;

    private UserDetailsService userDetailsService;

    @Autowired
    public UserService(MyUserRepo userRepo, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService, UserDetailsService userDetailsService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    public Users save(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public JwtResponseDTO verify(Users user) {

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        System.out.println("TEST AUTHENTICATION");


        if (authentication.isAuthenticated()) {
            String accessToken = jwtService.generateAccessToken(user.getUsername());
            String refreshToken = jwtService.generateRefreshToken(user.getUsername());
            return new JwtResponseDTO(accessToken, refreshToken);

        }
        throw new RuntimeException("Authentication failed");
    }

    public JwtResponseDTO refreshToken(HttpServletRequest request, HttpServletResponse response) {

        // extract the token from authorization header
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("HttpStatus.UNAUTHORIZED");
//            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        String token = authHeader.substring(7);

        // extract username from token
        String username = jwtService.extractUserName(token);

        // check if the user exist in database
        UserDetails user = userDetailsService.loadUserByUsername(username);
//                .orElseThrow(()->new RuntimeException("No user found"));
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        // check if the token is valid

        if (jwtService.validateToken(token, user)) {
            // generate access token
            String accessToken = jwtService.generateAccessToken(username);
            String refreshToken = jwtService.generateRefreshToken(username);

            return new JwtResponseDTO(accessToken, refreshToken);
//            return new ResponseEntity(accessToken, refreshToken, "New token generated"), HttpStatus.OK);
        }
        throw new RuntimeException("Invalid refresh token");
    }
    public Users findById(int id) {
        return userRepo.findById((long) id).orElse(null);
    }
}

