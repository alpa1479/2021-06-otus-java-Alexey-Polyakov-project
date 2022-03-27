package edu.issuetracker.domain.issue.service.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.issue.model.IssueType;
import edu.issuetracker.domain.issue.repository.IssueTypeRepository;
import edu.issuetracker.domain.issue.service.IssueTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class IssueTypeServiceImpl implements IssueTypeService {

    private final TransactionManager transactionManager;
    private final IssueTypeRepository issueTypeRepository;

    @Override
    public Set<IssueType> getIssueTypes() {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Set<IssueType> types = issueTypeRepository.findAll();
            log.info("issue types: {}", types);
            return types;
        });
    }
}
