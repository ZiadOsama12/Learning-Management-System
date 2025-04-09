package com.learningmanagementsystem.application.usecases;

import com.learningmanagementsystem.application.dto.AssignRoleRequestDTO;
import com.learningmanagementsystem.application.service.UserService;
import com.learningmanagementsystem.domain.entity.Role;
import com.learningmanagementsystem.domain.entity.UserRole;
import com.learningmanagementsystem.domain.entity.UserRoleId;
import com.learningmanagementsystem.domain.entity.Users;
import com.learningmanagementsystem.domain.exception.EntityNotFoundException;
import com.learningmanagementsystem.domain.repository.MyUserRepo;
import com.learningmanagementsystem.domain.repository.RoleRepo;
import com.learningmanagementsystem.domain.repository.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AssignRoleToUserUseCase {
    @Autowired
    private MyUserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    public Users execute(AssignRoleRequestDTO assignRoleRequestDTO) {

        String username = assignRoleRequestDTO.getUsername();
        Users user = userRepo.findByUsername(username);

        if (user == null) {
            throw new EntityNotFoundException("User", "username", username);
        }

        Set<UserRole> userRoles = user.getRoles(); // current roles
        if (userRoles == null) {
            userRoles = new HashSet<>();
        }

        for (String roleName : assignRoleRequestDTO.getRolesNames()) {
            Role role = roleRepo.findByName(roleName);
            if (role == null) {
                throw new EntityNotFoundException("Role", "Name", roleName);
            }

            // create composite key
            UserRoleId id = new UserRoleId(user.getId(), role.getId());

            // check if this role is already assigned
            boolean alreadyExists = userRoles.stream()
                    .anyMatch(ur -> ur.getId().equals(id));
            if (alreadyExists) continue;

            // create UserRole
            UserRole userRole = new UserRole();
            userRole.setId(id);
            userRole.setUser(user);
            userRole.setRole(role);

            // add to user's roles
            user.addRole(userRole);
            userRoleRepo.save(userRole);
// Try to use save all
//            userRoles.add(userRole);

        }
        userRepo.save(user); // save user with updated roles
        return user;
    }

}
