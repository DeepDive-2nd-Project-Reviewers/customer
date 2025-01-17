package reviewers.customer.domain.answer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.question.entity.Question;
import reviewers.customer.domain.student.entity.Student;
import reviewers.customer.global.common.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "answer")
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(nullable = false, length = 200)
    private String answer;

    public static Answer createAnswer(String answer, Student student, Question question) {
        Answer answerEntity = new Answer();
        answerEntity.question = question;
        answerEntity.answer = answer;
        answerEntity.student = student;
        return answerEntity;
    }
}