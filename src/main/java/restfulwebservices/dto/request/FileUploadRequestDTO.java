package restfulwebservices.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadRequestDTO {
    private MultipartFile file;       // Single file upload
}
