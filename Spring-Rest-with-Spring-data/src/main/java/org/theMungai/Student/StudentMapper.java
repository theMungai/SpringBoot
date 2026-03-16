package org.theMungai.Student;

import org.springframework.stereotype.Component;
import org.theMungai.School.School;

@Component
public class StudentMapper {

    // method to convert StudentDto object to student object
    public Student toStudent(StudentDTO dto){
        if (dto == null){
            throw new NullPointerException("The student Dto should not be null");
        }
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
    public StudentResponseDTO toStudentResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}
