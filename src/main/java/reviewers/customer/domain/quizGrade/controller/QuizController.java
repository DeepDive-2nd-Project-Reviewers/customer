package reviewers.customer.domain.quizGrade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reviewers.customer.domain.quizGrade.dto.QuizGradeListResponseDto;
import reviewers.customer.domain.quizGrade.dto.QuizGradeRequestDto;
import reviewers.customer.domain.quizGrade.service.QuizService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/score")
    public QuizGradeListResponseDto score(@RequestBody QuizGradeRequestDto quizGradeRequestDto) {
        return quizService.findAllByStudentId(quizGradeRequestDto.getStudentId());
    }
}