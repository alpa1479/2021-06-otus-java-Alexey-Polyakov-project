package edu.issuetracker.domain.controller.project;

import edu.issuetracker.domain.model.project.ProjectStatus;
import edu.issuetracker.domain.service.project.ProjectStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ProjectStatusRestController {

    private final ProjectStatusService projectStatusService;

    @GetMapping("/api/project-statuses")
    public ResponseEntity<Set<ProjectStatus>> getProjectStatuses() {
        return ResponseEntity.ok(projectStatusService.getProjectStatuses());
    }
}
