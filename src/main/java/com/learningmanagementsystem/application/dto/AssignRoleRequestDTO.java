package com.learningmanagementsystem.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignRoleRequestDTO {
    @NotBlank(message = "Username is empty")
    private String username;
    private Set<String> rolesNames;
}
