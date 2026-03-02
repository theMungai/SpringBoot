package org.theMungai;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(@RequestBody Student student){
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    // Find student by ID
    @GetMapping("/students/{studentId}")
    public Student findStudentById(@PathVariable Long studentId){
        return repository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with id " + studentId + " not found."));
    }

    // Find student by name
    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(@PathVariable("student-name") String name){
        return repository.findAllByFirstnameContaining(name);
    }

    // Delete student
    @DeleteMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        repository.deleteById(studentId);
    }
}
