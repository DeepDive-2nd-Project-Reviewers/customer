package reviewers.customer.domain.assignmentGrade.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeOverallResponseDto;
import reviewers.customer.domain.assignmentGrade.mapper.AssignmentGradeMapper;
import reviewers.customer.domain.assignmentGrade.repository.AssignmentGradeRepository;
import reviewers.customer.domain.course.entity.Course;
import reviewers.customer.domain.course.service.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentGradeRepository assignmentGradeRepository;
    private final AssignmentGradeMapper assignmentGradeMapper;
    private final CourseService courseService;

    public AssignmentGradeOverallResponseDto overallAssignmentGrade(Long courseId){
        Course course = courseService.findById(courseId);
        return assignmentGradeMapper.toDto(course, getAverageGrade(courseId), getMaxGrade(courseId), getMinGrade(courseId), getDistribution(courseId));
    }

    private Integer getMinGrade(Long courseId) {
        return assignmentGradeRepository.findMinGradeByCourseId(courseId).orElse(0);
    }

    private Integer getMaxGrade(Long courseId) {
        return assignmentGradeRepository.findMaxGradeByCourseId(courseId).orElse(0);
    }

    private Double getAverageGrade(Long courseId) {
        return assignmentGradeRepository.findAvgGradeByCourseId(courseId).orElse(0.0);
    }

    private AssignmentGradeOverallResponseDto.GradeDistribution getDistribution(Long courseId){
        List<Integer> distribution = assignmentGradeRepository.findGradeDistributionByCourseId(courseId);
        return AssignmentGradeOverallResponseDto.GradeDistribution.builder()
                .A(distribution.get(0))
                .B(distribution.get(1))
                .C(distribution.get(2))
                .D(distribution.get(3))
                .F(distribution.get(4))
                .build();
    }
}
