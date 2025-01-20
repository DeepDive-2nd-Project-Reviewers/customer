package reviewers.customer.domain.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reviewers.customer.domain.assignment.entity.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourse_CourseId(Long courseId);
}