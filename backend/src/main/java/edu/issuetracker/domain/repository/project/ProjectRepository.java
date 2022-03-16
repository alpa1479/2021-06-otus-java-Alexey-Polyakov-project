package edu.issuetracker.domain.repository.project;

import edu.issuetracker.domain.model.project.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>, CustomProjectRepository {
}
