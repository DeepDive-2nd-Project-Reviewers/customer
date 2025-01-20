package reviewers.customer.domain.quizGrade.mapper;

import org.springframework.stereotype.Component;
import reviewers.customer.domain.quizGrade.dto.QuizGradeListResponseDto;
import reviewers.customer.domain.quizGrade.dto.QuizGradeResponseDto;
import reviewers.customer.domain.quizGrade.entity.QuizGrade;

import java.util.List;

@Component
public class QuizGradeMapper {

    public QuizGradeResponseDto toDto(QuizGrade quizGrade) {
        return QuizGradeResponseDto.builder()
                .quizId(quizGrade.getQuiz().getQuizId())
                .title(quizGrade.getQuiz().getQuizTitle())
                .point(quizGrade.getGrade())
                .build();
    }

    public QuizGradeListResponseDto toListDto(List<QuizGrade> quizList) {
        return QuizGradeListResponseDto.builder()
                .assignmentGrades(quizList.stream()
                        .map(this::toDto)
                        .toList())
                .build();
    }
}
