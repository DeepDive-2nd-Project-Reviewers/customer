package reviewers.customer.domain.assignmentGrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reviewers.customer.domain.assignmentGrade.entity.AssignmentGrade;

import java.util.List;
import java.util.Optional;

public interface AssignmentGradeRepository extends JpaRepository<AssignmentGrade, Long> {
    @Query("SELECT MAX(ag.grade) FROM AssignmentGrade ag JOIN ag.assignment a WHERE a.course.courseId = :courseId")
    Optional<Integer> findMaxGradeByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT MIN(ag.grade) FROM AssignmentGrade ag JOIN ag.assignment a WHERE a.course.courseId = :courseId")
    Optional<Integer> findMinGradeByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT AVG(ag.grade) FROM AssignmentGrade  ag JOIN ag.assignment a WHERE a.course.courseId = :courseID")
    Optional<Double> findAvgGradeByCourseId(@Param("courseID") Long courseID);

    @Query("""
    SELECT
        COUNT(CASE WHEN ag.grade BETWEEN 80 AND 100 THEN 1 END),
        COUNT(CASE WHEN ag.grade BETWEEN 60 AND 79 THEN 1 END),
        COUNT(CASE WHEN ag.grade BETWEEN 40 AND 59 THEN 1 END),
        COUNT(CASE WHEN ag.grade BETWEEN 20 AND 39 THEN 1 END),
        COUNT(CASE WHEN ag.grade < 20 THEN 1 END)
    FROM AssignmentGrade ag
    JOIN ag.assignment a
    JOIN a.course c
    WHERE c.courseId = :courseId
    """)
    List<Integer> findGradeDistributionByCourseId(@Param("courseId") Long courseId);

}