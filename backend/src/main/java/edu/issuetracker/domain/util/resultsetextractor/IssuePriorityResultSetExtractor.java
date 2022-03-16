package edu.issuetracker.domain.util.resultsetextractor;

import edu.issuetracker.domain.model.issue.IssuePriority;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class IssuePriorityResultSetExtractor implements ResultSetExtractor<Set<IssuePriority>> {

    @Override
    public Set<IssuePriority> extractData(ResultSet rs) throws SQLException {
        var priorities = new HashSet<IssuePriority>();
        while (rs.next()) {
            IssuePriority priority = new IssuePriority(rs.getLong("id"), rs.getString("name"));
            priorities.add(priority);
        }
        return priorities;
    }
}
