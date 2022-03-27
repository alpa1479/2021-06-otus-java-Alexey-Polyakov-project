package edu.issuetracker.domain.project.util.rowmapper;

import edu.issuetracker.domain.project.model.ProjectStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectStatusRowMapper implements RowMapper<ProjectStatus> {

    @Override
    public ProjectStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProjectStatus(rs.getLong("id"), rs.getString("name"));
    }
}
