package restfulwebservices.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restfulwebservices.domain.entity.StudentDetailsEntity;
import restfulwebservices.domain.repository.IStudentDetailsRepository;
import restfulwebservices.exception.ServiceNotFoundException;
import restfulwebservices.service.IStudentDetailsService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentDetailsService implements IStudentDetailsService {

    private final IStudentDetailsRepository studentDetailsRepository;

    @Override
    public StudentDetailsEntity createStudent(StudentDetailsEntity entity) {
        return studentDetailsRepository.save(entity);
    }

    @Override
    public StudentDetailsEntity updateStudent(StudentDetailsEntity entity) {
        if(entity.getStudentId()==null || !studentDetailsRepository.existsById(entity.getStudentId()))
        throw new ServiceNotFoundException("Student not Found with ID"+entity.getStudentId());
        return studentDetailsRepository.save(entity);
    }

    @Override
    public StudentDetailsEntity getStudentById(Integer studentId) {
        return studentDetailsRepository.findById(studentId)
                .orElseThrow(()->new ServiceNotFoundException("Student Not Found with Id: "+ studentId));
    }

    @Override
    public List<StudentDetailsEntity> getAllStudents() {
        return studentDetailsRepository.findAll();
    }

    @Override
    public void deleteStudent(Integer studentId) {
        if(!studentDetailsRepository.existsById(studentId)){
            throw new ServiceNotFoundException("Student Not Found with Id:"+studentId);
        }
        studentDetailsRepository.deleteById(studentId);
    }


}
