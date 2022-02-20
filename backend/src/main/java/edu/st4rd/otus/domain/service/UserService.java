package edu.st4rd.otus.domain.service;

import edu.st4rd.otus.domain.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
}
