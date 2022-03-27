package edu.issuetracker.domain.repository.project;

import edu.issuetracker.domain.model.project.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomProjectRepository {

    Page<Project> findAllPaginated(Pageable pageable, String search);
}
