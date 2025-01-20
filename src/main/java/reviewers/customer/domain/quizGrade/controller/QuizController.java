package reviewers.customer.domain.quizGrade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reviewers.customer.domain.quizGrade.dto.QuizGradeListResponseDto;
import reviewers.customer.domain.quizGrade.dto.QuizGradeRequestDto;
import reviewers.customer.domain.quizGrade.service.QuizService;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/score")
    public QuizGradeListResponseDto score(@RequestBody QuizGradeRequestDto quizGradeRequestDto) {
        return quizService.findAllByStudentId(quizGradeRequestDto.getStudentId());
    }
}