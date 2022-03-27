package edu.issuetracker.domain.project.service;

import edu.issuetracker.domain.project.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Page<Project> getProjectsPage(Pageable pageable, String search);
}
