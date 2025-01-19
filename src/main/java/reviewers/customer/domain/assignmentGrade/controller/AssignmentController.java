package reviewers.customer.domain.assignmentGrade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reviewers.customer.domain.assignmentGrade.service.AssignmentGradeService;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallRequestDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;

@RestController
@RequestMapping("/api/v1/assignment")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentGradeService assignmentGradeService;

    @PostMapping
    public AssignmentGradeOverallResponseDto getGradesDistribution(@RequestBody AssignmentGradeOverallRequestDto dto){
        return assignmentGradeService.overallAssignmentGrade(dto.getCourseId());
    }
}
