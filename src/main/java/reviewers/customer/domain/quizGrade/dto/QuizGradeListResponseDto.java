package reviewers.customer.domain.quizGrade.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QuizGradeListResponseDto {
    private List<QuizGradeResponseDto> assignmentGrades;
}
