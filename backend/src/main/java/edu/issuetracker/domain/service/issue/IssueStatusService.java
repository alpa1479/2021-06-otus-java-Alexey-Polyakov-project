package edu.issuetracker.domain.service.issue;

import edu.issuetracker.domain.model.issue.IssueStatus;

import java.util.Set;

public interface IssueStatusService {

    Set<IssueStatus> getIssueStatuses();
}
