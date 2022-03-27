package edu.issuetracker.domain.project.converter.impl;

import edu.issuetracker.core.util.Converter;
import edu.issuetracker.domain.project.model.Project;
import edu.issuetracker.domain.user.model.User;
import edu.issuetracker.domain.project.viewmodel.ProjectTableElementViewModel;
import edu.issuetracker.domain.project.viewmodel.UserTableElementViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectToProjectTableElementConverterImpl implements Converter<Project, ProjectTableElementViewModel> {

    private final Converter<User, UserTableElementViewModel> userToUserTableElementConverter;

    @Override
    public ProjectTableElementViewModel convert(Project project) {
        if (project == null) {
            return null;
        }
        return ProjectTableElementViewModel.builder()
                .id(project.getId())
                .title(project.getTitle())
                .status(project.getStatusName())
                .owner(userToUserTableElementConverter.convert(project.getOwner()))
                .createdDate(project.getCreatedDate())
                .updatedDate(project.getUpdatedDate())
                .closedDate(project.getClosedDate())
                .build();
    }
}
