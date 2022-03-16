package edu.issuetracker.domain.service.project;

import edu.issuetracker.domain.model.project.ProjectStatus;

import java.util.Set;

public interface ProjectStatusService {

    Set<ProjectStatus> getProjectStatuses();
}
