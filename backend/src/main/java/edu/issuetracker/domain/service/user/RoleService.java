package edu.issuetracker.domain.service.user;

import edu.issuetracker.domain.model.user.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Set<Role> getRoles();

    Optional<Role> getRole(Long id);
}
