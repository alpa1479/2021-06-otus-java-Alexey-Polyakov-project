package edu.issuetracker.domain.project.service.impl;

import edu.issuetracker.core.transactionmanager.TransactionManager;
import edu.issuetracker.domain.project.model.Project;
import edu.issuetracker.domain.project.repository.ProjectRepository;
import edu.issuetracker.domain.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final TransactionManager transactionManager;
    private final ProjectRepository projectRepository;

    @Override
    public Page<Project> getProjectsPage(Pageable pageable, String search) {
        return transactionManager.doInReadOnlyTransaction(() -> {
            Page<Project> projects = projectRepository.findAllPaginated(pageable, search);
            log.info("projects: {}", projects);
            return projects;
        });
    }
}
