package restfulwebservices.transformer;

import org.springframework.stereotype.Component;
import restfulwebservices.domain.entity.StudentDetailsEntity;
import restfulwebservices.dto.request.StudentRequestDTO;
import restfulwebservices.dto.response.StudentResponseDTO;

@Component
public class StudentDetailsTransformer {
    // toEntity
    public StudentDetailsEntity toEntity(StudentRequestDTO dto){
        if(dto==null) return null;
        StudentDetailsEntity entity = new StudentDetailsEntity();
        entity.setStudentName(dto.getStudentName());
        entity.setStudentCity(dto.getStudentCity());
        return entity;
    }

    // toDto
    public StudentResponseDTO toDto(StudentDetailsEntity entity){
        if(entity==null){
            return null;
        }
        StudentResponseDTO dto = new StudentResponseDTO();
        if(entity.getStudentId()!=null){
            dto.setStudentId(entity.getStudentId());
        }
        dto.setStudentName(entity.getStudentName());
        dto.setStudentCity(entity.getStudentCity());
        return dto;
    }
}
