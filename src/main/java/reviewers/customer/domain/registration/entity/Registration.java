package reviewers.customer.domain.registration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.course.entity.Course;
import reviewers.customer.domain.registration.enums.RegistrationStatus;
import reviewers.customer.domain.student.entity.Student;
import reviewers.customer.global.common.BaseTimeEntity;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "registration")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Registration extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_status", length = 20, nullable = false)
    private RegistrationStatus registrationStatus;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Builder
    private Registration(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public static Registration of(RegistrationStatus registrationStatus) {
        return Registration.builder()
                .build();
    }
}