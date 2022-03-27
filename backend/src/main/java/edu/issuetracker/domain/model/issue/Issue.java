package edu.issuetracker.domain.model.issue;

import edu.issuetracker.domain.model.project.Project;
import edu.issuetracker.domain.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Table("issues")
@EqualsAndHashCode(exclude = "id")
public class Issue {

    @Id
    private final Long id;
    private final String title;
    private final String description;
    private final IssueType type;
    private final IssueStatus status;
    private final IssuePriority priority;
    private final Project project;
    private final User assignee;
    private final User reporter;
    private final LocalDate createdDate;
    private final LocalDate updatedDate;
    private final LocalDate closedDate;
    private final LocalDate dueDate;
    private final LocalTime estimatedTime;
    private final LocalTime loggedTime;
}
