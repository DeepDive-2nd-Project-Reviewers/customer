package reviewers.customer.domain.assignmentGrade.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;
import reviewers.customer.domain.assignmentGrade.mapper.AssignmentGradeMapper;
import reviewers.customer.domain.assignmentGrade.repository.AssignmentGradeRepository;
import reviewers.customer.domain.course.entity.Course;
import reviewers.customer.domain.course.service.CourseService;

@Service
@RequiredArgsConstructor
public class AssignmentGradeService {

    private final AssignmentGradeRepository assignmentGradeRepository;
    private final AssignmentGradeMapper assignmentGradeMapper;
    private final CourseService courseService;

    public AssignmentGradeOverallResponseDto overallAssignmentGrade(Long courseId){
        Course course = courseService.findById(courseId);
        Object[] grades = getGrades(courseId);
        return assignmentGradeMapper.toDto(
                course, ((Number) grades[0]).doubleValue(), ((Number) grades[1]).intValue(), ((Number) grades[2]).intValue(), getDistribution(grades));
    }

    private Object[] getGrades(Long courseId){
        return assignmentGradeRepository.findGradeDistributionByCourseId(courseId).get(0);
    }

    private AssignmentGradeOverallResponseDto.GradeDistribution getDistribution(Object[] grades) {
        return AssignmentGradeOverallResponseDto.GradeDistribution.builder()
                .A(((Number) grades[3]).intValue())
                .B(((Number) grades[4]).intValue())
                .C(((Number) grades[5]).intValue())
                .D(((Number) grades[6]).intValue())
                .F(((Number) grades[7]).intValue())
                .build();
    }
}
