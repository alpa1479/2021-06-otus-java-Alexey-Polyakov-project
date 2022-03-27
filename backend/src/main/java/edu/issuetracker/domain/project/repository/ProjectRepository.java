package edu.issuetracker.domain.project.repository;

import edu.issuetracker.domain.project.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>, CustomProjectRepository {
}
