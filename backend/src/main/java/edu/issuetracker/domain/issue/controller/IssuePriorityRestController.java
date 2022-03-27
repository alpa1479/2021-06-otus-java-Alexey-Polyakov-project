package edu.issuetracker.domain.issue.controller;

import edu.issuetracker.domain.issue.model.IssuePriority;
import edu.issuetracker.domain.issue.service.IssuePriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class IssuePriorityRestController {

    private final IssuePriorityService issuePriorityService;

    @GetMapping("/api/issue-priorities")
    public Set<IssuePriority> getIssuePriorities() {
        return issuePriorityService.getIssuePriorities();
    }
}
