package edu.issuetracker.domain.service.user.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.model.user.Role;
import edu.issuetracker.domain.repository.user.RoleRepository;
import edu.issuetracker.domain.service.user.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final TransactionManager transactionManager;
    private final RoleRepository roleRepository;

    @Override
    public Set<Role> getRoles() {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Set<Role> roles = roleRepository.findAll();
            log.info("roles: {}", roles);
            return roles;
        });
    }

    @Override
    public Optional<Role> getRole(Long id) {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Optional<Role> role = roleRepository.findById(id);
            log.info("role: {}", role);
            return role;
        });
    }
}
