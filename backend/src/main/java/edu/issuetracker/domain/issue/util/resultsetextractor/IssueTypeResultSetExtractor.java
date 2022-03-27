package edu.issuetracker.domain.issue.util.resultsetextractor;

import edu.issuetracker.domain.issue.model.IssueType;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class IssueTypeResultSetExtractor implements ResultSetExtractor<Set<IssueType>> {

    @Override
    public Set<IssueType> extractData(ResultSet rs) throws SQLException {
        var types = new HashSet<IssueType>();
        while (rs.next()) {
            IssueType type = new IssueType(rs.getLong("id"), rs.getString("name"));
            types.add(type);
        }
        return types;
    }
}
