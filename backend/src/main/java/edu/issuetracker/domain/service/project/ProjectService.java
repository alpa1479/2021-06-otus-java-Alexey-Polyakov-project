package edu.issuetracker.domain.service.project;

import edu.issuetracker.domain.model.project.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

    Page<Project> getProjectsPage(Pageable pageable, String search);
}
