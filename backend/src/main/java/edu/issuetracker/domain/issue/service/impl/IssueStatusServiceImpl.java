package edu.issuetracker.domain.issue.service.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.issue.model.IssueStatus;
import edu.issuetracker.domain.issue.repository.IssueStatusRepository;
import edu.issuetracker.domain.issue.service.IssueStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class IssueStatusServiceImpl implements IssueStatusService {

    private final TransactionManager transactionManager;
    private final IssueStatusRepository issueStatusRepository;

    @Override
    public Set<IssueStatus> getIssueStatuses() {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Set<IssueStatus> statuses = issueStatusRepository.findAll();
            log.info("issue statuses: {}", statuses);
            return statuses;
        });
    }
}
