package edu.issuetracker.domain.service.project.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.model.project.ProjectStatus;
import edu.issuetracker.domain.repository.project.ProjectStatusRepository;
import edu.issuetracker.domain.service.project.ProjectStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectStatusServiceImpl implements ProjectStatusService {

    private final TransactionManager transactionManager;
    private final ProjectStatusRepository projectStatusRepository;

    @Override
    public Set<ProjectStatus> getProjectStatuses() {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Set<ProjectStatus> statuses = projectStatusRepository.findAll();
            log.info("project statuses: {}", statuses);
            return statuses;
        });
    }
}
