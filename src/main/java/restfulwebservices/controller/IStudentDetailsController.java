package restfulwebservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restfulwebservices.dto.request.StudentRequestDTO;
import restfulwebservices.dto.response.StudentResponseDTO;
import restfulwebservices.wrapper.ApiResponse;

import java.util.List;

@RequestMapping("/api/students")
public interface IStudentDetailsController {

    @Operation(summary = "Create a new student")
    @PostMapping("/create")
    ResponseEntity<ApiResponse<StudentResponseDTO>> createStudent(@RequestBody StudentRequestDTO requestDTO);

    @Operation(summary = "Update an existing student")
    @PutMapping("/update")
    ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent(@RequestBody StudentRequestDTO requestDTO);

    @Operation(summary = "Get a student by ID")
    @GetMapping("/get")
    ResponseEntity<ApiResponse<StudentResponseDTO>> getStudentById(@RequestParam Integer studentId);

    @Operation(summary = "Get all students")
    @GetMapping("/all")
    ResponseEntity<ApiResponse<List<StudentResponseDTO>>> getAllStudents();

    @Operation(summary = "Delete a student by ID")
    @DeleteMapping("/delete")
    ResponseEntity<ApiResponse<Void>> deleteStudent(@RequestParam Integer studentId);
}
