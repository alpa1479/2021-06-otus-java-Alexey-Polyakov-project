package edu.issuetracker.domain.util.resultsetextractor;

import edu.issuetracker.domain.model.user.Role;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class RoleResultSetExtractor implements ResultSetExtractor<Set<Role>> {

    @Override
    public Set<Role> extractData(ResultSet rs) throws SQLException {
        var roles = new HashSet<Role>();
        while (rs.next()) {
            Role role = new Role(rs.getLong("id"), rs.getString("name"));
            roles.add(role);
        }
        return roles;
    }
}
