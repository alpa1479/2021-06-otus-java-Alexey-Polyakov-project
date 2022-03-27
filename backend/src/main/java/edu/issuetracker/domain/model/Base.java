package edu.issuetracker.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Base {

    @Id
    private Long id;
    private String name;
}
