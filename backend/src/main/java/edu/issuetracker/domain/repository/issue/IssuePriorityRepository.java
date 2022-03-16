package edu.issuetracker.domain.repository.issue;

import edu.issuetracker.domain.model.issue.IssuePriority;
import edu.issuetracker.domain.util.resultsetextractor.IssuePriorityResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IssuePriorityRepository extends CrudRepository<IssuePriority, Long> {

    @Override
    @Query(value = "select id, name from issue_priorities", resultSetExtractorClass = IssuePriorityResultSetExtractor.class)
    Set<IssuePriority> findAll();
}
