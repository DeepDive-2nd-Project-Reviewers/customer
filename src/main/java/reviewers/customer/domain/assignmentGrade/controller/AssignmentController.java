package reviewers.customer.domain.assignmentGrade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeListResponseDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeRequestDto;
import reviewers.customer.domain.assignmentGrade.service.AssignmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AssignmentController {
    private final AssignmentService assignmentService;

    @GetMapping("assignment/grades")
    public AssignmentGradeListResponseDto getAssignmentGradeByStudentId(@RequestBody AssignmentGradeRequestDto request) {
        return assignmentService.findAllByStudentId(request.getStudentId());
    }
}
