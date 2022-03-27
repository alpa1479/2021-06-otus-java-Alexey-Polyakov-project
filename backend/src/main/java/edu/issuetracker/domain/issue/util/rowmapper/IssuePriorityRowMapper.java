package edu.issuetracker.domain.issue.util.rowmapper;

import edu.issuetracker.domain.issue.model.IssuePriority;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IssuePriorityRowMapper implements RowMapper<IssuePriority> {

    @Override
    public IssuePriority mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new IssuePriority(rs.getLong("id"), rs.getString("name"));
    }
}
