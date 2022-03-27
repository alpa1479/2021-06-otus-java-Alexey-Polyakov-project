package edu.issuetracker.domain.issue.util.rowmapper;

import edu.issuetracker.domain.issue.model.IssueType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueTypeRowMapper implements RowMapper<IssueType> {

    @Override
    public IssueType mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new IssueType(rs.getLong("id"), rs.getString("name"));
    }
}