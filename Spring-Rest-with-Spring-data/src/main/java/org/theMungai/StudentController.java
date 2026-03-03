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
    public StudentResponseDTO post(@RequestBody StudentDTO dto){

        var student = toStudent(dto);
        var savedStudent = repository.save(student);
        return toStudentResponseDTO(savedStudent);
    }

    // method to convert StudentDto object to student object
    private Student toStudent(StudentDTO dto){

        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    // method to convert StudentResponseDto object to student object
    private StudentResponseDTO toStudentResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
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
