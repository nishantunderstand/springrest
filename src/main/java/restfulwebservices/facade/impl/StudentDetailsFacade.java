package restfulwebservices.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restfulwebservices.domain.entity.StudentDetailsEntity;
import restfulwebservices.dto.request.StudentRequestDTO;
import restfulwebservices.dto.response.StudentResponseDTO;
import restfulwebservices.facade.IStudentDetailsFacade;
import restfulwebservices.service.IStudentDetailsService;
import restfulwebservices.transformer.StudentDetailsTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentDetailsFacade implements IStudentDetailsFacade {
    private final IStudentDetailsService studentDetailsService;
    private final StudentDetailsTransformer studentDetailsTransformer;

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) {
        StudentDetailsEntity entity = studentDetailsTransformer.toEntity(requestDTO);
        StudentDetailsEntity savedEntity = studentDetailsService.createStudent(entity);
        return studentDetailsTransformer.toDto(savedEntity);
    }

    @Override
    public StudentResponseDTO updateStudent(StudentRequestDTO requestDTO) {
        StudentDetailsEntity entity = studentDetailsTransformer.toEntity(requestDTO);
        StudentDetailsEntity savedEntity = studentDetailsService.updateStudent(entity);
        return studentDetailsTransformer.toDto(savedEntity);
    }

    @Override
    public StudentResponseDTO getStudentById(Integer studentId) {
        StudentDetailsEntity entity = studentDetailsService.getStudentById(studentId);
        return studentDetailsTransformer.toDto(entity);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<StudentDetailsEntity> entities = studentDetailsService.getAllStudents();
        return entities.stream()
                .map(studentDetailsTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentDetailsService.deleteStudent(studentId);

    }
}
