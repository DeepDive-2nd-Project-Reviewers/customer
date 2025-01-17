package reviewers.customer.domain.assignmentGrade.mapper;

import org.springframework.stereotype.Component;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;
import reviewers.customer.domain.course.entity.Course;

@Component
public class AssignmentGradeMapper {
    public AssignmentGradeOverallResponseDto toDto(Course course, int averageGrade, int highestGrade, int lowestGrade,
            int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
        AssignmentGradeOverallResponseDto.GradeDistribution gradeDistribution = createGradeDistribution(gradeA, gradeB, gradeC, gradeD, gradeF);

        return AssignmentGradeOverallResponseDto.builder()
                .courseId(course.getCourseId())
                .courseTitle(course.getCourseTitle())
                .averageGrade(averageGrade)
                .highestGrade(highestGrade)
                .lowestGrade(lowestGrade)
                .gradeDistribution(gradeDistribution)
                .build();
    }

    public AssignmentGradeOverallResponseDto.GradeDistribution createGradeDistribution(int gradeA, int gradeB, int gradeC, int gradeD, int gradeF) {
        return new AssignmentGradeOverallResponseDto.GradeDistribution(gradeA, gradeB, gradeC, gradeD, gradeF);
    }
}