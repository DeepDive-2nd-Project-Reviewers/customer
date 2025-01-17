package reviewers.customer.domain.quizGrade.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizGradeResponseDto {
    private Long quizId;

    private String title;

    private int point;
}
