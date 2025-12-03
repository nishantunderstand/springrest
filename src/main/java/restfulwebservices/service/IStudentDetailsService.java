package restfulwebservices.service;

import restfulwebservices.domain.entity.StudentDetailsEntity;

import java.util.List;

public interface IStudentDetailsService {
    StudentDetailsEntity createStudent(StudentDetailsEntity entity);
    StudentDetailsEntity updateStudent(StudentDetailsEntity entity);
    StudentDetailsEntity getStudentById(Integer studentId);
    List<StudentDetailsEntity> getAllStudents();
    void deleteStudent(Integer studentId);
}
