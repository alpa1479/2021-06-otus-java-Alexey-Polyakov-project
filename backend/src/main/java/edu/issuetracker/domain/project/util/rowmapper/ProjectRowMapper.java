package edu.issuetracker.domain.project.util.rowmapper;

import edu.issuetracker.domain.project.model.Project;
import edu.issuetracker.domain.project.model.ProjectStatus;
import edu.issuetracker.domain.user.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Project.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .status(new ProjectStatus(rs.getLong("status_id"), rs.getString("status_name")))
                .owner(new User(rs.getLong("owner_id"), rs.getString("owner_username")))
                .createdDate(Optional.ofNullable(rs.getDate("created_date")).map(Date::toLocalDate).orElse(null))
                .updatedDate(Optional.ofNullable(rs.getDate("updated_date")).map(Date::toLocalDate).orElse(null))
                .closedDate(Optional.ofNullable(rs.getDate("closed_date")).map(Date::toLocalDate).orElse(null))
                .build();
    }
}
