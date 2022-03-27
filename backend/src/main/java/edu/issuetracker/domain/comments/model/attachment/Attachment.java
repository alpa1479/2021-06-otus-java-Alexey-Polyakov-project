package edu.issuetracker.domain.comments.model.attachment;

import edu.issuetracker.domain.issue.model.Issue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("comments")
@EqualsAndHashCode(exclude = "id")
public class Attachment {

    @Id
    private final Long id;
    private final String name;
    private final byte[] data;
    private final Issue issue;
    private final LocalDate uploadedDate;
}
