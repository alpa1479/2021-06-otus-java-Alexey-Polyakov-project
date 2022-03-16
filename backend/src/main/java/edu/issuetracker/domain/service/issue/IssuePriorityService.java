package edu.issuetracker.domain.service.issue;

import edu.issuetracker.domain.model.issue.IssuePriority;

import java.util.Set;

public interface IssuePriorityService {

    Set<IssuePriority> getIssuePriorities();
}
