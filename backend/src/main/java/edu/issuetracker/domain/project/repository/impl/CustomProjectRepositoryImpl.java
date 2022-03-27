package edu.issuetracker.domain.project.repository.impl;

import edu.issuetracker.core.util.QueryFormatter;
import edu.issuetracker.domain.project.model.Project;
import edu.issuetracker.domain.project.repository.CustomProjectRepository;
import edu.issuetracker.domain.project.util.rowmapper.ProjectRowMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomProjectRepositoryImpl implements CustomProjectRepository {

    private static final String SEARCH_QUERY = " where LOWER(title) ~ LOWER(?)";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Page<Project> findAllPaginated(Pageable pageable, String search) {
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
                """;
        boolean searchable = StringUtils.isNotEmpty(search);
        String countQuery = "select count(*) from projects";
        if (searchable) {
            query += SEARCH_QUERY;
            countQuery += SEARCH_QUERY;
        }
        query += """
                order by %s
                limit %d offset %d
                """.formatted(QueryFormatter.toOrderByString(pageable.getSort()), pageable.getPageSize(), pageable.getOffset());
        Long count;
        List<Project> projects;
        if (searchable) {
            count = jdbcTemplate.queryForObject(countQuery, Long.class, search);
            projects = jdbcTemplate.query(query, new ProjectRowMapper(), search);
        } else {
            count = jdbcTemplate.queryForObject(countQuery, Long.class);
            projects = jdbcTemplate.query(query, new ProjectRowMapper());
        }
        return new PageImpl<>(projects, pageable, Optional.ofNullable(count).orElse(0L));
    }
}
