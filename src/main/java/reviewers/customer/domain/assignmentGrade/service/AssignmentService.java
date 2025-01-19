package reviewers.customer.domain.assignmentGrade.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reviewers.customer.domain.assignmentGrade.dto.AssignmentGradeListResponseDto;
import reviewers.customer.domain.assignmentGrade.entity.AssignmentGrade;
import reviewers.customer.domain.assignmentGrade.mapper.AssignmentGradeMapper;
import reviewers.customer.domain.assignmentGrade.repository.AssignmentGradeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentGradeMapper assignmentGradeMapper;
    private final AssignmentGradeRepository assignmentGradeRepository;

    public AssignmentGradeListResponseDto findAllByStudentId(Long studentId) {
        List<AssignmentGrade> grades = assignmentGradeRepository.findAllByStudentId(studentId);
        return assignmentGradeMapper.toListDto(grades);
    }

}
