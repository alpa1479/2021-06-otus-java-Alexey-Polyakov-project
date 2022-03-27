package edu.issuetracker.domain.converter.impl;

import edu.issuetracker.domain.converter.Converter;
import edu.issuetracker.domain.model.project.Project;
import edu.issuetracker.domain.model.user.User;
import edu.issuetracker.domain.viewmodel.project.ProjectTableElementViewModel;
import edu.issuetracker.domain.viewmodel.user.UserTableElementViewModel;
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
