package edu.issuetracker.domain.repository.issue;

import edu.issuetracker.domain.model.issue.IssueStatus;
import edu.issuetracker.domain.util.resultsetextractor.IssueStatusResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IssueStatusRepository extends CrudRepository<IssueStatus, Long> {

    @Override
    @Query(value = "select id, name from issue_statuses", resultSetExtractorClass = IssueStatusResultSetExtractor.class)
    Set<IssueStatus> findAll();
}
