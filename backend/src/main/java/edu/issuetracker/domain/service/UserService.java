package edu.issuetracker.domain.service;

import edu.issuetracker.domain.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
}
