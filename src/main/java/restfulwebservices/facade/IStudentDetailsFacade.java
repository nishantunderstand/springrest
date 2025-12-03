package restfulwebservices.facade;

import restfulwebservices.dto.request.StudentRequestDTO;
import restfulwebservices.dto.response.StudentResponseDTO;

import java.util.List;

public interface IStudentDetailsFacade {
    StudentResponseDTO createStudent(StudentRequestDTO requestDTO);
    StudentResponseDTO updateStudent(StudentRequestDTO requestDTO);
    StudentResponseDTO getStudentById(Integer studentId);
    List<StudentResponseDTO> getAllStudents();
    void deleteStudent(Integer studentId);
}
