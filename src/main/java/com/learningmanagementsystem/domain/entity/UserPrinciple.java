package com.learningmanagementsystem.domain.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserPrinciple implements UserDetails {

    private Users user;

    public UserPrinciple(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Arrays
//                .stream(user
//                        .getRole()
//                        .(","))
//                .map(SimpleGrantedAuthority::new)
//                .toList();
//        return List.of(new SimpleGrantedAuthority("ANY_ROLE")); // Replace with any role name
        System.out.println();
        return user.getRoles().stream()
                .map(userRoles -> {
                    String roleName = userRoles.getRole().getName();  // Extract role name
                    System.out.println("Role: " + roleName); // Print to console

                    return new SimpleGrantedAuthority(userRoles.getRole().getName());
                }) // Assuming `getRoleName()` exists
                .toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
