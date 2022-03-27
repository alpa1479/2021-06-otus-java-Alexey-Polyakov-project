package edu.issuetracker.domain.controller.user;

import edu.issuetracker.domain.model.user.Role;
import edu.issuetracker.domain.service.user.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class RoleRestController {

    private final RoleService roleService;

    @GetMapping("/api/roles")
    public Set<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/api/roles/{id}")
    public Role getRoleById(@PathVariable(name = "id") long id) {
        return roleService.getRole(id).orElse(null);
    }
}
