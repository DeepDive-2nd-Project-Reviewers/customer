package reviewers.customer.domain.assignmentGrade.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AssignmentGradeListResponseDto {
    private List<AssignmentGradeResponseDto> assignmentGrades;
}
