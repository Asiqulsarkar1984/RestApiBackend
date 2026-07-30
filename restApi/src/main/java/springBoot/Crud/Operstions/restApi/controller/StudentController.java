package springBoot.Crud.Operstions.restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBoot.Crud.Operstions.restApi.entity.Student;
import springBoot.Crud.Operstions.restApi.repository.StudentRepository;

import java.util.List;

@RestController

@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository repo;

    @GetMapping
    public List<Student>getAllStudents(){
      List<Student>students = repo.findAll();
        return students;
    }
    @GetMapping("/id")
    public Student getStudentById(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }


}
