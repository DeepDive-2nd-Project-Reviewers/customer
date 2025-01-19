package reviewers.customer.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Success implements SuccessInterface{
    _GET_DISTRIBUTION("성적 통계 조회 성공");

    private final String message;
}
