package edu.issuetracker.domain.role.util.rowmapper;

import edu.issuetracker.domain.role.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Role(rs.getLong("id"), rs.getString("name"));
    }
}
