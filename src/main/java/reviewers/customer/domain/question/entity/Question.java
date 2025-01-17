package reviewers.customer.domain.question.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reviewers.customer.domain.answer.entity.Answer;
import reviewers.customer.domain.quiz.entity.Quiz;
import reviewers.customer.global.common.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "question")
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = false, length = 200)
    private String correct;

    @Column(nullable = false)
    private Integer point;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    public static Question createQuestion(Quiz quiz, String content, String correct, Integer point) {
        Question question = new Question();
        question.quiz = quiz;
        question.content = content;
        question.correct = correct;
        question.point = point;
        quiz.getQuestions().add(question);
        return question;

    }
}