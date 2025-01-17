package reviewers.customer.domain.quizGrade.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.quiz.entity.Quiz;
import reviewers.customer.domain.student.entity.Student;

@Getter
@NoArgsConstructor
@Entity
@Table
public class QuizGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_grade_id")
    private Long quizGradeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false)
    private Byte grade;

    public static QuizGrade create(Student student, Quiz  quiz, Byte grade) {
        QuizGrade quizGrade = new QuizGrade();
        quizGrade.student = student;
        quizGrade.quiz = quiz;
        quizGrade.grade = grade;
        return quizGrade;
    }
}