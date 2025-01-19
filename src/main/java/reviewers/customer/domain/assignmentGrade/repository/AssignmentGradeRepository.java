package reviewers.customer.domain.assignmentGrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reviewers.customer.domain.assignmentGrade.entity.AssignmentGrade;

import java.util.List;

public interface AssignmentGradeRepository extends JpaRepository<AssignmentGrade, Long> {
    @Query("""
    SELECT
        COALESCE(AVG(ag.grade), 0.0),
        COALESCE(MAX(ag.grade), 0),
        COALESCE(MIN(ag.grade), 0),
        COALESCE(COUNT(CASE WHEN ag.grade BETWEEN 80 AND 100 THEN 1 END), 0),
        COALESCE(COUNT(CASE WHEN ag.grade BETWEEN 60 AND 79 THEN 1 END), 0),
        COALESCE(COUNT(CASE WHEN ag.grade BETWEEN 40 AND 59 THEN 1 END), 0),
        COALESCE(COUNT(CASE WHEN ag.grade BETWEEN 20 AND 39 THEN 1 END), 0),
        COALESCE(COUNT(CASE WHEN ag.grade < 20 THEN 1 END), 0)
    FROM AssignmentGrade ag
    JOIN ag.assignment a
    JOIN a.course c
    WHERE c.courseId = :courseId
    """)
    List<Object[]> findGradeDistributionByCourseId(@Param("courseId") Long courseId);
}