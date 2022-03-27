package edu.issuetracker.domain.issue.service;

import edu.issuetracker.domain.issue.model.IssuePriority;

import java.util.Set;

public interface IssuePriorityService {

    Set<IssuePriority> getIssuePriorities();
}
