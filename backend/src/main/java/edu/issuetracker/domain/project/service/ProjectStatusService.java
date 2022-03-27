package edu.issuetracker.domain.project.service;

import edu.issuetracker.domain.project.model.ProjectStatus;

import java.util.Set;

public interface ProjectStatusService {

    Set<ProjectStatus> getProjectStatuses();
}
