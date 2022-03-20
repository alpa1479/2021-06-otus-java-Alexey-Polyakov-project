package edu.issuetracker.domain.controller.user;

import edu.issuetracker.domain.model.user.User;
import edu.issuetracker.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UsersRestController {

    private final UserService userService;

    @GetMapping("/api/users/{id}")
    public User getClientById(@PathVariable(name = "id") long id) {
        return userService.getUser(id).orElse(null);
    }
}
