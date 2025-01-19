package reviewers.customer.domain.assignmentGrade.mapper;

import org.springframework.stereotype.Component;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeListResponseDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeResponseDto;
import reviewers.customer.domain.assignmentGrade.entity.AssignmentGrade;

import java.util.List;

@Component
public class AssignmentGradeMapper {
    public AssignmentGradeResponseDto toDto(AssignmentGrade assignmentGrade) {
        return AssignmentGradeResponseDto.builder()
                .assignmentId(assignmentGrade.getAssignment().getId())
                .title(assignmentGrade.getAssignment().getTitle())
                .grade(assignmentGrade.getGrade())
                .feedback(assignmentGrade.getFeedback())
//                TODO: 이 부분 연관 관계 수정해야 할 듯
//                .submissionDate(/*이거를 어떻게 가져오지?*/)
                .build();
    }

    public AssignmentGradeListResponseDto toListDto(List<AssignmentGrade> assignmentGrades) {
        return AssignmentGradeListResponseDto.builder()
                .assignmentGrades(assignmentGrades.stream()
                        .map(this::toDto)
                        .toList())
                .build();
    }
}
