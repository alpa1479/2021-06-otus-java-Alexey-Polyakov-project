package edu.issuetracker.domain.service.user;

import edu.issuetracker.domain.model.user.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
}
