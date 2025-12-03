package restfulwebservices.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import restfulwebservices.controller.IStudentDetailsController;
import restfulwebservices.dto.request.StudentRequestDTO;
import restfulwebservices.dto.response.StudentResponseDTO;
import restfulwebservices.facade.IStudentDetailsFacade;
import restfulwebservices.wrapper.ApiResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentDetailsController implements IStudentDetailsController {
    private final IStudentDetailsFacade studentDetailsFacade;


    @Override
    public ResponseEntity<ApiResponse<StudentResponseDTO>> createStudent(StudentRequestDTO requestDTO) {
        StudentResponseDTO response = studentDetailsFacade.createStudent(requestDTO);
        return ResponseEntity.ok(ApiResponse.ok("Student Created Successfully",response));
    }

    @Override
    public ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent(StudentRequestDTO requestDTO) {
        StudentResponseDTO response = studentDetailsFacade.updateStudent(requestDTO);
        return ResponseEntity.ok(ApiResponse.ok("Student Updated Successfully",response));
    }

    @Override
    public ResponseEntity<ApiResponse<StudentResponseDTO>> getStudentById(Integer studentId) {
        StudentResponseDTO response = studentDetailsFacade.getStudentById(studentId);
        return ResponseEntity.ok(ApiResponse.ok("Student Retrieved Successfully",response));
    }

    @Override
    public ResponseEntity<ApiResponse<List<StudentResponseDTO>>> getAllStudents() {
        List<StudentResponseDTO> response = studentDetailsFacade.getAllStudents();
        return ResponseEntity.ok(ApiResponse.ok("Student Created Successfully",response));
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> deleteStudent(Integer studentId) {
        studentDetailsFacade.deleteStudent(studentId);
        return ResponseEntity.ok(ApiResponse.ok("Student Created Successfully",null));
    }
}
