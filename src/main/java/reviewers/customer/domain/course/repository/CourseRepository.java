package reviewers.customer.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reviewers.customer.domain.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseId(Long courseId);
}
