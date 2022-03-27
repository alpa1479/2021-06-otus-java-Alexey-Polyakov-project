package edu.issuetracker.domain.project.repository;

import edu.issuetracker.domain.project.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomProjectRepository {

    Page<Project> findAllPaginated(Pageable pageable, String search);
}
