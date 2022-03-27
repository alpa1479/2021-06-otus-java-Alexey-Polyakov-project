package edu.issuetracker.domain.issue.repository;

import edu.issuetracker.domain.issue.model.IssuePriority;
import edu.issuetracker.domain.issue.util.rowmapper.IssuePriorityRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IssuePriorityRepository extends CrudRepository<IssuePriority, Long> {

    @Override
    @Query(value = "select id, name from issue_priorities", rowMapperClass = IssuePriorityRowMapper.class)
    Set<IssuePriority> findAll();
}
