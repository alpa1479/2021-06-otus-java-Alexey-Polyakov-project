package edu.issuetracker.domain.user.service;

import edu.issuetracker.domain.user.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
}
