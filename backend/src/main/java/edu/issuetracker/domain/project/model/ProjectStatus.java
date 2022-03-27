package edu.issuetracker.domain.project.model;

import edu.issuetracker.core.model.Base;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("project_statuses")
public class ProjectStatus extends Base {

    @PersistenceConstructor
    public ProjectStatus(Long id, String name) {
        super(id, name);
    }
}
