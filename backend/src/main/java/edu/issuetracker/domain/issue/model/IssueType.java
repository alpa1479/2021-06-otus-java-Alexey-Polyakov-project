package edu.issuetracker.domain.issue.model;

import edu.issuetracker.core.model.Base;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("issue_types")
public class IssueType extends Base {

    @PersistenceConstructor
    public IssueType(Long id, String name) {
        super(id, name);
    }
}
