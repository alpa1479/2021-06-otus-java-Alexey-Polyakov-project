package edu.issuetracker.domain.issue.service;

import edu.issuetracker.domain.issue.model.IssueStatus;

import java.util.Set;

public interface IssueStatusService {

    Set<IssueStatus> getIssueStatuses();
}
