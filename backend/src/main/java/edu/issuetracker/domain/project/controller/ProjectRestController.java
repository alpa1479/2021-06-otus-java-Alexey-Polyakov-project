package edu.issuetracker.domain.project.controller;

import edu.issuetracker.core.util.Converter;
import edu.issuetracker.domain.project.model.Project;
import edu.issuetracker.domain.project.service.ProjectService;
import edu.issuetracker.core.viewmodel.PageViewModel;
import edu.issuetracker.domain.project.viewmodel.ProjectTableElementViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectRestController {

    private final ProjectService projectService;
    private final Converter<Project, ProjectTableElementViewModel> projectToProjectTableElementConverter;

    @CrossOrigin("*")
    @GetMapping("/api/projects")
    public PageViewModel<ProjectTableElementViewModel> getProjectsPage(@PageableDefault(size = 10)
                                                                       @SortDefault.SortDefaults({
                                                                               @SortDefault(sort = "status_id"),
                                                                               @SortDefault(sort = "created_date", direction = Sort.Direction.DESC)
                                                                       }) Pageable pageable, @RequestParam(value = "search", required = false) String search) {
        Page<Project> projectsPage = projectService.getProjectsPage(pageable, search);
        return projectToProjectTableElementConverter.convert(projectsPage);
    }
}
