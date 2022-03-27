package edu.issuetracker.domain.service.issue;

import edu.issuetracker.domain.model.issue.IssueType;

import java.util.Set;

public interface IssueTypeService {

    Set<IssueType> getIssueTypes();
}
