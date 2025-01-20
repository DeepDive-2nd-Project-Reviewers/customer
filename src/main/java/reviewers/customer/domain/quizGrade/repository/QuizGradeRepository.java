package reviewers.customer.domain.quizGrade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reviewers.customer.domain.quizGrade.entity.QuizGrade;

import java.util.List;

public interface QuizGradeRepository extends JpaRepository<QuizGrade, Long> {
    List<QuizGrade> findAllByStudent_Id(Long studentId);
}
