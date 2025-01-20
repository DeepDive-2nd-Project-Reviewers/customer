package reviewers.customer.global.success;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuccessResponse<T> {
    private Integer code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> SuccessResponse<T> ok(SuccessResponseStatus successResponseStatus, T data) {
        return SuccessResponse.<T>builder()
                .code(HttpStatus.OK.value())
                .message(successResponseStatus.getMessage())
                .data(data)
                .build();
    }
}
