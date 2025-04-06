package com.learningmanagementsystem.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
// Check Again Auth. Using Roles...........M to M

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER) // Field  in UseRole
    private Set<UserRole> roles;

    public void addRole(UserRole role) {
        this.roles.add(role);
    }
}
