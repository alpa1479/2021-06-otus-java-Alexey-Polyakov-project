package edu.issuetracker.domain.role.service;

import edu.issuetracker.domain.role.model.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Set<Role> getRoles();

    Optional<Role> getRole(Long id);
}
