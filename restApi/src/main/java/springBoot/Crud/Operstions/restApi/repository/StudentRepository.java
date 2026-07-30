package springBoot.Crud.Operstions.restApi.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import springBoot.Crud.Operstions.restApi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

