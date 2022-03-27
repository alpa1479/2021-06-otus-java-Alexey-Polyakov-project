package edu.issuetracker.domain.viewmodel.project;

import edu.issuetracker.domain.viewmodel.user.UserTableElementViewModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ProjectTableElementViewModel {

    private final Long id;
    private final String title;
    private final String status;
    private final UserTableElementViewModel owner;
    private final LocalDate createdDate;
    private final LocalDate updatedDate;
    private final LocalDate closedDate;
}
