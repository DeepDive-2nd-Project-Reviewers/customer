package reviewers.customer.domain.quizGrade.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reviewers.customer.domain.quizGrade.dto.QuizGradeListResponseDto;
import reviewers.customer.domain.quizGrade.entity.QuizGrade;
import reviewers.customer.domain.quizGrade.mapper.QuizGradeMapper;
import reviewers.customer.domain.quizGrade.repository.QuizGradeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizGradeRepository quizGradeRepository;
    private final QuizGradeMapper quizGradeMapper;

    public QuizGradeListResponseDto findAllByStudentId(Long studentId) {
        List<QuizGrade> grades = quizGradeRepository.findAllByStudent_Id(studentId);
        return quizGradeMapper.toListDto(grades);
    }
}
