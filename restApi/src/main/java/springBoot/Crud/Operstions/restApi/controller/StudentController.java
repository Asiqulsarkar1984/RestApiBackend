package springBoot.Crud.Operstions.restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBoot.Crud.Operstions.restApi.entity.Student;
import springBoot.Crud.Operstions.restApi.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Added curly braces to capture the ID variable
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    // Added curly braces and fixed string spacing
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Student with Roll no " + id + " deleted successfully";
        } else {
            return "Student not found";
        }
    }

    @DeleteMapping("/all")
    public String deleteAllStudent() {
        if (repo.count() > 0) {
            repo.deleteAllInBatch();
            return "All students deleted successfully";
        } else {
            return "No students found to delete";
        }
    }

    // Changed @PathVariable to @RequestBody to accept JSON payloads
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return repo.save(student);
    }

    // Mapped the URL to accept the ID variable and match the @PathVariable
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student existingStudent = repo.findById(id).orElse(null);

        // Update fields if the student exists
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setPercentage(updatedStudent.getPercentage());
            existingStudent.setBranch(updatedStudent.getBranch());

            // Note: We deliberately do NOT update the primary key (rollNo)

            return repo.save(existingStudent);
        }
        return null;
    }
}