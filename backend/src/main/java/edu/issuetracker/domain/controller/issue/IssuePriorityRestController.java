package edu.issuetracker.domain.controller.issue;

import edu.issuetracker.domain.model.issue.IssuePriority;
import edu.issuetracker.domain.service.issue.IssuePriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Set<IssuePriority>> getIssuePriorities() {
        return ResponseEntity.ok(issuePriorityService.getIssuePriorities());
    }
}
