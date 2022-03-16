package edu.issuetracker.domain.util.resultsetextractor;

import edu.issuetracker.domain.model.issue.IssueStatus;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class IssueStatusResultSetExtractor implements ResultSetExtractor<Set<IssueStatus>> {

    @Override
    public Set<IssueStatus> extractData(ResultSet rs) throws SQLException {
        var statuses = new HashSet<IssueStatus>();
        while (rs.next()) {
            IssueStatus status = new IssueStatus(rs.getLong("id"), rs.getString("name"));
            statuses.add(status);
        }
        return statuses;
    }
}
