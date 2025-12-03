package restfulwebservices.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfulwebservices.domain.entity.StudentDetailsEntity;

public interface IStudentDetailsRepository extends JpaRepository<StudentDetailsEntity,Integer> {
}
