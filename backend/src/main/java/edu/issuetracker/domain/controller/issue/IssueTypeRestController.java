package edu.issuetracker.domain.controller.issue;

import edu.issuetracker.domain.model.issue.IssueType;
import edu.issuetracker.domain.service.issue.IssueTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Set<IssueType>> getIssueTypes() {
        return ResponseEntity.ok(issueTypeService.getIssueTypes());
    }
}
