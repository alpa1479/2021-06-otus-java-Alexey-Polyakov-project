package edu.issuetracker.domain.model.comment;

import edu.issuetracker.domain.model.issue.Issue;
import edu.issuetracker.domain.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("comments")
@EqualsAndHashCode(exclude = "id")
public class Comment {

    @Id
    private final Long id;
    private final User user;
    private final Issue issue;
    private final String text;
    private final LocalDate createdDate;
    private final LocalDate updatedDate;
}
