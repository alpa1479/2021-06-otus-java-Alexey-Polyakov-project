package edu.issuetracker.domain.repository.project.impl;

import edu.issuetracker.domain.model.project.Project;
import edu.issuetracker.domain.repository.project.CustomProjectRepository;
import edu.issuetracker.domain.util.QueryFormatter;
import edu.issuetracker.domain.util.rowmapper.ProjectRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RequiredArgsConstructor
public class CustomProjectRepositoryImpl implements CustomProjectRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Page<Project> findAllPaginated(Pageable pageable) {
        String countQuery = "select count(*) from projects";
        long count = jdbcTemplate.queryForObject(countQuery, Long.class);
        String query = """
                select p.id                 as id,
                       p.title              as title,
                       p.created_date       as created_date,
                       p.updated_date       as updated_date,
                       p.closed_date        as closed_date,
                            
                       s.id                 as status_id,
                       s.name               as status_name,

                       o.id                 as owner_id,
                       o.username           as owner_username
                from projects p
                         left outer join project_statuses s
                                         on s.id = p.status_id
                         left outer join users o
                                         on o.id = p.owner_id
                order by %s
                limit %d offset %d
                """.formatted(QueryFormatter.toOrderByString(pageable.getSort()), pageable.getPageSize(), pageable.getOffset());
        List<Project> projects = jdbcTemplate.query(query, new ProjectRowMapper());
        return new PageImpl<>(projects, pageable, count);
    }
}
