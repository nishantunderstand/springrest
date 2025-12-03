package restfulwebservices.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentResponseDTO {
    private Integer studentId;
    private String studentName;
    private String studentCity;
}
