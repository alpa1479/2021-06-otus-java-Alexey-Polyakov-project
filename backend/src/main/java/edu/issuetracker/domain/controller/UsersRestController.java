package edu.issuetracker.domain.controller;

import edu.issuetracker.domain.model.User;
import edu.issuetracker.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersRestController {

    private final UserService userService;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getClientById(@PathVariable(name = "id") long id) {
        return ResponseEntity.of(userService.getUser(id));
    }
}
