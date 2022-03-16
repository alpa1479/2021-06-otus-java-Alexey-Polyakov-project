package edu.issuetracker.domain.model.project;

import edu.issuetracker.domain.model.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Builder
@Table("projects")
@EqualsAndHashCode(exclude = "id")
public class Project {

    @Id
    private final Long id;
    private final String title;
    private final String description;
    private final ProjectStatus status;
    private final User owner;
    private final LocalDate createdDate;
    private final LocalDate updatedDate;
    private final LocalDate closedDate;
}
