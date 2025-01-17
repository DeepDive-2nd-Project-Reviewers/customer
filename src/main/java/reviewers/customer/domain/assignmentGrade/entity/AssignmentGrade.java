package reviewers.customer.domain.assignmentGrade.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.assignment.entity.Assignment;
import reviewers.customer.domain.student.entity.Student;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AssignmentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private int grade;

    private String feedback;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    private AssignmentGrade(Assignment assignment, Student student, int grade, String feedback, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.assignment = assignment;
        this.student = student;
        this.grade = grade;
        this.feedback = feedback;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static AssignmentGrade of(Assignment assignment, Student student, int grade, String feedback) {
        return AssignmentGrade.builder()
                .assignment(assignment)
                .student(student)
                .grade(grade)
                .feedback(feedback)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}