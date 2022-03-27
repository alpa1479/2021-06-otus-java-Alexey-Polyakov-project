package edu.issuetracker.domain.issue.util.rowmapper;

import edu.issuetracker.domain.issue.model.IssueStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueStatusRowMapper implements RowMapper<IssueStatus> {

    @Override
    public IssueStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new IssueStatus(rs.getLong("id"), rs.getString("name"));
    }
}
