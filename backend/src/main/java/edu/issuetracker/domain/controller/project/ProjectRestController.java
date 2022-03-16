package edu.issuetracker.domain.controller.project;

import edu.issuetracker.domain.model.project.Project;
import edu.issuetracker.domain.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ProjectRestController {

    private final ProjectService projectService;

    @GetMapping("/api/projects")
    public ResponseEntity<Page<Project>> getProjectsPage(@PageableDefault(size = 20)
                                                         @SortDefault.SortDefaults({
                                                                 @SortDefault(sort = "status_id"),
                                                                 @SortDefault(sort = "created_date", direction = Sort.Direction.DESC)
                                                         }) Pageable pageable) {
        return ResponseEntity.ok(projectService.getProjectsPage(pageable));
    }
}
