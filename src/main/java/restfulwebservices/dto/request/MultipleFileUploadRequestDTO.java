package restfulwebservices.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MultipleFileUploadRequestDTO {
    private MultipartFile[] files;   // Multiple files
}
