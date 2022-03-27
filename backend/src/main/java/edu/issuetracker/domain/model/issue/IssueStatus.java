package edu.issuetracker.domain.model.issue;

import edu.issuetracker.domain.model.Base;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("issue_statuses")
public class IssueStatus extends Base {

    @PersistenceConstructor
    public IssueStatus(Long id, String name) {
        super(id, name);
    }
}
