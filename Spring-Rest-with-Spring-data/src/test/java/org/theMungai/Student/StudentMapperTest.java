package org.theMungai.Student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentMapperTest {

    private StudentMapper mapper;  // You have to first declare the service you want to test

    @BeforeEach
    void setUp(){
        mapper =  new StudentMapper();
    }

    // testing toEntity(toStudent) method
    @Test
    public void shouldMapStudentDtoToStudent(){
        StudentDTO dto = new StudentDTO("John", "Doe", "john@mail.com", 1L);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());  // Relationship check
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    // testing toDto(toStudentResponseDto) method
    @Test
    public void shouldMapStudentToStudentResponseDto(){
        //Given
        Student student = new Student("Joel", "Miles", "miles@gmail.com", 20);

        //When
        StudentResponseDTO response = mapper.toStudentResponseDTO(student);

        // Then (expects)
        assertEquals(response.firstname(), student.getFirstname());
        assertEquals(response.lastname(), student.getLastname());
        assertEquals(response.email(), student.getEmail());
    }

    @Test
    public void should_trow_null_pointer_exception_when_studentDto_is_null(){
        var message = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));

        assertEquals("The student Dto should not be null", message.getMessage());
    }

}