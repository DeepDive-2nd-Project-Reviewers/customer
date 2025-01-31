package reviewers.customer.domain.Instructor.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.teaching.entity.Teaching;
import reviewers.customer.domain.user.entity.User;
import reviewers.customer.domain.user.enums.Role;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "instructor")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Instructor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Long id;

    @Column(name = "instructor_descroption", nullable = false)
    private String description;

    @OneToMany(mappedBy = "instructor", cascade = ALL)
    private List<Teaching> teachings = new ArrayList<>();

    @Builder
    private Instructor(String loginId, String password, String email, String name, String description) {
        super(loginId, password, email, name, Role.INSTRUCTOR);
        this.description = description;
    }

    public static Instructor of(String loginId, String password, String email, String name, String description) {
        return Instructor.builder()
                .loginId(loginId)
                .password(password)
                .email(email)
                .name(name)
                .description(description)
                .build();
    }
}