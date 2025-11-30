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
public class ApiPageAbleResponse<T> {

    private boolean success;
    private String message;
    private List<T> data;
    private Instant timestamp;

    // Offset-based pagination block
    private Pagination pagination;

    // Cursor-based pagination block
    private String nextCursor;
    private boolean hasNext;

    // ----------------------------
    // Pagination Inner Class
    // ----------------------------
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Pagination {
        private int page;
        private int size;
        private long offset;
        private long totalItems;
        private int totalPages;
    }

    // ---------------------------------------------------
    // OFFSET PAGINATION RESPONSE (Page + Size)
    // ---------------------------------------------------
    public static <T> ApiPageAbleResponse<T> offset(
            String message,
            List<T> data,
            int page,
            int size,
            long totalItems
    ) {

        long offset = (long) (page - 1) * size;
        int totalPages = (int) Math.ceil((double) totalItems / size);

        Pagination pagination = Pagination.builder()
                .page(page)
                .size(size)
                .offset(offset)
                .totalItems(totalItems)
                .totalPages(totalPages)
                .build();

        return ApiPageAbleResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .pagination(pagination)
                .timestamp(Instant.now())
                .build();
    }

    // ---------------------------------------------------
    // KEYSET PAGINATION RESPONSE (Cursor-Based)
    // ---------------------------------------------------
    public static <T> ApiPageAbleResponse<T> keyset(
            String message,
            List<T> data,
            String nextCursor,
            boolean hasNext
    ) {
        return ApiPageAbleResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .nextCursor(nextCursor)
                .hasNext(hasNext)
                .timestamp(Instant.now())
                .build();
    }

    // ---------------------------------------------------
    // ERROR RESPONSE
    // ---------------------------------------------------
    public static <T> ApiPageAbleResponse<T> error(String message) {
        return ApiPageAbleResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .timestamp(Instant.now())
                .build();
    }
}
