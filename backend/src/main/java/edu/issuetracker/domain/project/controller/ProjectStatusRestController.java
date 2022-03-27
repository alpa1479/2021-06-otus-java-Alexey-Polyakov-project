package edu.issuetracker.domain.project.controller;

import edu.issuetracker.domain.project.model.ProjectStatus;
import edu.issuetracker.domain.project.service.ProjectStatusService;
import lombok.RequiredArgsConstructor;
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
    public Set<ProjectStatus> getProjectStatuses() {
        return projectStatusService.getProjectStatuses();
    }
}
