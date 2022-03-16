package edu.issuetracker.domain.service.issue.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.model.issue.IssuePriority;
import edu.issuetracker.domain.repository.issue.IssuePriorityRepository;
import edu.issuetracker.domain.service.issue.IssuePriorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class IssuePriorityServiceImpl implements IssuePriorityService {

    private final TransactionManager transactionManager;
    private final IssuePriorityRepository issuePriorityRepository;

    @Override
    public Set<IssuePriority> getIssuePriorities() {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Set<IssuePriority> priorities = issuePriorityRepository.findAll();
            log.info("priorities: {}", priorities);
            return priorities;
        });
    }
}
