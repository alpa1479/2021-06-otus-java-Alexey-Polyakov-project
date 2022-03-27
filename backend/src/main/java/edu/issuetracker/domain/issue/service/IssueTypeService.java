package edu.issuetracker.domain.issue.service;

import edu.issuetracker.domain.issue.model.IssueType;

import java.util.Set;

public interface IssueTypeService {

    Set<IssueType> getIssueTypes();
}
