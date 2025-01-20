package reviewers.customer.domain.assignmentGrade.mapper;

import org.springframework.stereotype.Component;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeListResponseDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeResponseDto;
import reviewers.customer.domain.assignmentGrade.entity.AssignmentGrade;
import reviewers.customer.domain.course.entity.Course;

import java.util.List;

@Component
public class AssignmentGradeMapper {
    public AssignmentGradeResponseDto toDto(AssignmentGrade assignmentGrade) {
        return AssignmentGradeResponseDto.builder()
                .assignmentId(assignmentGrade.getAssignment().getId())
                .title(assignmentGrade.getAssignment().getTitle())
                .grade(assignmentGrade.getGrade())
                .build();
    }

    public AssignmentGradeListResponseDto toListDto(List<AssignmentGrade> assignmentGrades) {
        return AssignmentGradeListResponseDto.builder()
                .assignmentGrades(assignmentGrades.stream()
                        .map(this::toDto)
                        .toList())
                .build();
    }
    public AssignmentGradeOverallResponseDto toDto(Course course, double averageGrade, int highestGrade, int lowestGrade,
                                                   AssignmentGradeOverallResponseDto.GradeDistribution distribution) {
        return AssignmentGradeOverallResponseDto.builder()
                .courseId(course.getCourseId())
                .courseTitle(course.getCourseTitle())
                .averageGrade(averageGrade)
                .highestGrade(highestGrade)
                .lowestGrade(lowestGrade)
                .gradeDistribution(distribution)
                .build();
    }

}
