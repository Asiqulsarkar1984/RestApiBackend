package springBoot.Crud.Operstions.restApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBoot.Crud.Operstions.restApi.entity.Student;
import springBoot.Crud.Operstions.restApi.repository.StudentRepository;

import java.util.List;

@CrossOrigin(origins = "https://wahidx-crud-application.vercel.app")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student saved = repo.save(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,
                                                 @RequestBody Student updatedStudent) {

        return repo.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setBranch(updatedStudent.getBranch());
                    student.setPercentage(updatedStudent.getPercentage());

                    Student saved = repo.save(student);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found");
        }

        repo.deleteById(id);

        return ResponseEntity.ok("Student deleted successfully");
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllStudents() {

        if (repo.count() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No students found");
        }

        repo.deleteAll();

        return ResponseEntity.ok("All students deleted successfully");
    }
}