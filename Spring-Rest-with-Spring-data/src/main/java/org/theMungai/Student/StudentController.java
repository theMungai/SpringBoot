package org.theMungai.Student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@Valid @RequestBody StudentDTO dto){return this.service.saveStudent(dto);}

    @GetMapping("/students")
    public List<StudentResponseDTO> findAllStudents(){return this.service.findAllStudent();}

    // Find student by ID
    @GetMapping("/students/{studentId}")
    public StudentResponseDTO findStudentById(@PathVariable Long studentId){return this.service.findStudentById(studentId);}

    // Find student by name
    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDTO> findStudentsByName(@PathVariable("student-name") String name){return service.findStudentsByName(name);}

    // Delete student
    @DeleteMapping("/students/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("studentId") Long studentId){service.deleteStudent(studentId);}

    // validation error handling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
