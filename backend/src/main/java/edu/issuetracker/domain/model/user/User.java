package edu.issuetracker.domain.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("users")
@EqualsAndHashCode(exclude = "id")
public class User {

    @Id
    private final Long id;
    private final String username;
    private final String password;
    private final byte[] avatar;
    private final LocalDate registrationDate;
    private final String bio;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
        this.password = null;
        this.avatar = null;
        this.registrationDate = null;
        this.bio = null;
    }
}
