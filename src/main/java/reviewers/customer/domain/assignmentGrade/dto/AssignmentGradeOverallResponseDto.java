package reviewers.customer.domain.assignmentGrade.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AssignmentGradeOverallResponseDto {
    private Long courseId;

    private String courseTitle;

    private Double averageGrade;

    private int highestGrade;

    private int lowestGrade;

    private GradeDistribution gradeDistribution;

    @Getter
    @Builder
    public static class GradeDistribution {
        private final int A;
        private final int B;
        private final int C;
        private final int D;
        private final int F;

        public GradeDistribution(int A, int B, int C, int D, int F) {
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            this.F = F;
        }
    }
}