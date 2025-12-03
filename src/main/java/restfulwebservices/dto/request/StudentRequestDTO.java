package restfulwebservices.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentRequestDTO {
    private String studentName;
    private String studentCity;
}
