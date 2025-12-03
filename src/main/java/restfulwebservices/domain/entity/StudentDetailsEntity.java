package restfulwebservices.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_details")
@Getter
@Setter
@NoArgsConstructor
public class StudentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for MySQL AUTO_INCREMENT
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_city")
    private String studentCity;

}
