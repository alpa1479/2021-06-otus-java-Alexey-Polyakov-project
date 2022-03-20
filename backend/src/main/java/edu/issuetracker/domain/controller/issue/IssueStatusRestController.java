package edu.issuetracker.domain.controller.issue;

import edu.issuetracker.domain.model.issue.IssueStatus;
import edu.issuetracker.domain.service.issue.IssueStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class IssueStatusRestController {

    private final IssueStatusService issueStatusService;

    @GetMapping("/api/issue-statuses")
    public Set<IssueStatus> getIssueStatuses() {
        return issueStatusService.getIssueStatuses();
    }
}
