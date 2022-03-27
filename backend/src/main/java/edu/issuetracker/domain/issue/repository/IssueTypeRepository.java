package edu.issuetracker.domain.issue.repository;

import edu.issuetracker.domain.issue.model.IssueType;
import edu.issuetracker.domain.issue.util.resultsetextractor.IssueTypeResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IssueTypeRepository extends CrudRepository<IssueType, Long> {

    @Override
    @Query(value = "select id, name from issue_types", resultSetExtractorClass = IssueTypeResultSetExtractor.class)
    Set<IssueType> findAll();
}
