package edu.issuetracker.domain.role.repository;

import edu.issuetracker.domain.role.model.Role;
import edu.issuetracker.domain.role.util.resultsetextractor.RoleResultSetExtractor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Override
    @Query(value = "select id, name from roles", resultSetExtractorClass = RoleResultSetExtractor.class)
    Set<Role> findAll();
}
