package edu.issuetracker.domain.issue.repository;

import edu.issuetracker.domain.issue.model.IssueStatus;
import edu.issuetracker.domain.issue.util.rowmapper.IssueStatusRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IssueStatusRepository extends CrudRepository<IssueStatus, Long> {

    @Override
    @Query(value = "select id, name from issue_statuses", rowMapperClass = IssueStatusRowMapper.class)
    Set<IssueStatus> findAll();
}
