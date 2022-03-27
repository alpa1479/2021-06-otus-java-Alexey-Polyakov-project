package edu.issuetracker.domain.issue.controller;

import edu.issuetracker.domain.issue.model.IssueType;
import edu.issuetracker.domain.issue.service.IssueTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class IssueTypeRestController {

    private final IssueTypeService issueTypeService;

    @GetMapping("/api/issue-types")
    public Set<IssueType> getIssueTypes() {
        return issueTypeService.getIssueTypes();
    }
}
