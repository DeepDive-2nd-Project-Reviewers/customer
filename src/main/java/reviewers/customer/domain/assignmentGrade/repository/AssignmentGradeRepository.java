package reviewers.customer.domain.assignmentGrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reviewers.customer.domain.assignmentGrade.entity.AssignmentGrade;

import java.util.List;

public interface AssignmentGradeRepository extends JpaRepository<AssignmentGrade, Long> {
}
