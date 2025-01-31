package reviewers.customer.domain.student.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.answer.entity.Answer;
import reviewers.customer.domain.quizGrade.entity.QuizGrade;
import reviewers.customer.domain.registration.entity.Registration;
import reviewers.customer.domain.user.entity.User;
import reviewers.customer.domain.user.enums.Role;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "student")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @OneToMany(mappedBy = "student", cascade = ALL)
    private List<Registration> registrations = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = ALL)
    private List<Answer> answers = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = ALL)
    private List<QuizGrade> quizGrades = new ArrayList<>();

//    @OneToMany(mappedBy = "student", cascade = ALL) //TODO: 과제 성적 생성 후 진행
//    private List<AssigmentGrade> assigmentGrades = new ArrayList<>();

    @Builder
    private Student(String loginId, String password, String email, String name) {
        super(loginId, password, email, name, Role.STUDENT);
    }

    public static Student of(String loginId, String password, String email, String name) {
        return Student.builder()
                .loginId(loginId)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}