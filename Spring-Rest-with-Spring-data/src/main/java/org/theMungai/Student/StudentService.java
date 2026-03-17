package org.theMungai.Student;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    private final StudentRepository repository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> findAllStudent(){
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    // Find student by ID
    public StudentResponseDTO findStudentById(@PathVariable Long studentId){
        return repository.findById(studentId)
                .map(studentMapper::toStudentResponseDTO)
                .orElse(null);
    }

    // Find student by name
    public List<StudentResponseDTO> findStudentsByName(String name){
        return repository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    // Delete student
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        repository.deleteById(studentId);
    }

}
