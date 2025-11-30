package restfulwebservices.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfiniteScrollResponse<T> {

    private boolean success;
    private String message;
    private List<T> data;
    private Instant timestamp;
    private String nextCursor;
    private boolean hasNext;

    public static <T> InfiniteScrollResponse<T> ok(String message, List<T> data, String nextCursor, boolean hasNext) {
        return InfiniteScrollResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .nextCursor(nextCursor)
                .hasNext(hasNext)
                .timestamp(Instant.now())
                .build();
    }

    public static <T> InfiniteScrollResponse<T> error(String message) {
        return InfiniteScrollResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .nextCursor(null)
                .hasNext(false)
                .timestamp(Instant.now())
                .build();
    }
}
