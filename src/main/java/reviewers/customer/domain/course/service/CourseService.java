package reviewers.customer.domain.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reviewers.customer.domain.course.entity.Course;
import reviewers.customer.domain.course.repository.CourseRepository;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }
}
