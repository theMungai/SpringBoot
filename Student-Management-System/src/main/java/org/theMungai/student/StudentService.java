package org.theMungai.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentRequest createStudent(){

    }

    public StudentRequest updateStudent(){

    }

    public StudentRequest deleteStudent(){

    }


    public List<StudentResponse> findAllStudents(){

    }

    public StudentResponse findStudentById(){

    }
}
