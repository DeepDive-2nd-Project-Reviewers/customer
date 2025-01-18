package reviewers.customer.domain.assignmentGrade.mapper;

import org.springframework.stereotype.Component;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;
import reviewers.customer.domain.course.entity.Course;

@Component
public class AssignmentGradeMapper {
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