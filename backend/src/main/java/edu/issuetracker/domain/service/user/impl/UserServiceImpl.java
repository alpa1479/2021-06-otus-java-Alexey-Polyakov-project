package edu.issuetracker.domain.service.user.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.model.user.User;
import edu.issuetracker.domain.repository.user.UserRepository;
import edu.issuetracker.domain.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final TransactionManager transactionManager;
    private final UserRepository userRepository;

    @Override
    public Optional<User> getUser(Long id) {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Optional<User> user = userRepository.findById(id);
            log.info("client: {}", user);
            return user;
        });
    }
}
