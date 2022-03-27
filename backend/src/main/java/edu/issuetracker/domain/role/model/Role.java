package edu.issuetracker.domain.role.model;

import edu.issuetracker.core.model.Base;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("roles")
public class Role extends Base {

    @PersistenceConstructor
    public Role(Long id, String name) {
        super(id, name);
    }
}
