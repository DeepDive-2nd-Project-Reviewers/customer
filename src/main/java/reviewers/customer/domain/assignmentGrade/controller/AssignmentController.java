package reviewers.customer.domain.assignmentGrade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeListResponseDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallRequestDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeRequestDto;
import reviewers.customer.domain.assignmentGrade.service.AssignmentService;
import reviewers.customer.global.success.SuccessResponse;
import reviewers.customer.global.success.SuccessResponseStatus;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AssignmentController {
    private final AssignmentService assignmentService;

    @GetMapping("/assignment/grades")
    public AssignmentGradeListResponseDto getAssignmentGradeByStudentId(@RequestBody AssignmentGradeRequestDto request) {
        return assignmentService.findAllByStudentId(request.getStudentId());
    }

    @PostMapping("/assignment/distribution")
    public SuccessResponse<AssignmentGradeOverallResponseDto> getGradesDistribution(@RequestBody AssignmentGradeOverallRequestDto dto) {
        AssignmentGradeOverallResponseDto response = assignmentService.overallAssignmentGrade(dto.getCourseId());
        return SuccessResponse.ok(SuccessResponseStatus._GET_DISTRIBUTION, response);
    }
}