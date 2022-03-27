package edu.issuetracker.domain.user.controller;

import edu.issuetracker.domain.user.model.User;
import edu.issuetracker.domain.user.service.UserService;
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
