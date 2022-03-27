package edu.issuetracker.domain.project.util.resultsetextractor;

import edu.issuetracker.domain.project.model.ProjectStatus;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProjectStatusResultSetExtractor implements ResultSetExtractor<Set<ProjectStatus>> {

    @Override
    public Set<ProjectStatus> extractData(ResultSet rs) throws SQLException {
        var statuses = new HashSet<ProjectStatus>();
        while (rs.next()) {
            ProjectStatus status = new ProjectStatus(rs.getLong("id"), rs.getString("name"));
            statuses.add(status);
        }
        return statuses;
    }

}
