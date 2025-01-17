package reviewers.customer.domain.content.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import reviewers.customer.domain.course.entity.Course;
import reviewers.customer.global.common.BaseTimeEntity;

@Entity
@Table(name = "content")
@NoArgsConstructor
@Getter
public class Content extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long contentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "file_type", length = 100, nullable = false)
    private String fileType;

    @Column(name = "file_name", length = 100, nullable = false)
    private String fileName;

    @Column(name = "file_url", length = 300, nullable = false)
    private String fileUrl;

    @Builder
    public Content(Course course, String fileType, String fileName, String fileUrl) {
        this.course = course;
        this.fileType = fileType;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public static Content of(Course course, String fileType, String fileName, String fileUrl) {
        return Content.builder()
                .course(course)
                .fileType(fileType)
                .fileName(fileName)
                .fileUrl(fileUrl)
                .build();
    }
}