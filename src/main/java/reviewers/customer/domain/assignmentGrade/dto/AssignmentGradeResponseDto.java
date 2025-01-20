package reviewers.customer.domain.assignmentGrade.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AssignmentGradeResponseDto {
    private long assignmentId;
    private String title;
    private long grade;
}