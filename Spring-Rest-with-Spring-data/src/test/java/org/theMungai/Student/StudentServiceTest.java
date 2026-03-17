package org.theMungai.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // Firstly you have to define the service that you want to test
    // We use @InjectMocks annotation that helps us to tell the Mockito framework that we want to inject the dependencies to the service that we are testing.
    // When we try to initialize the tested service (e.g. StudentService), the Mockito framework looks for the objects that are annotated @Mocks
    @InjectMocks
    private StudentService studentService;

    // Declare dependencies if they are available
    // Then we will use @Mock annotation to each dependency to tell our test class and Mockito framework which dependencies we want to mock.

    @Mock
    private StudentRepository repository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  //Initializes and activates all Mockito annotations in the test class, creating the mock objects before each test runs.
    }

    @Test
    public void should_successfully_save_a_student(){

        // Arrange -> What do I need before I run this?
        StudentDTO dto = new StudentDTO("John", "Doe", "john@example.com", 1L);
        Student student = new Student("John", "Doe", "john@example.com", 20);
        Student savedStudent = new Student("John", "Doe", "john@example.com", 20);
        savedStudent.setId(1L);

        // Mock the calls -> We need to mock every call that uses another dependency
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDTO(savedStudent)).thenReturn(new StudentResponseDTO("John", "Doe", "john@example.com"));

        //Act -> What am I testing? => Probably the returnType
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Assert -> Does it work as expected?
        assertEquals(dto.firstname(), responseDTO.firstname());
        assertEquals(dto.lastname(), responseDTO.lastname());
        assertEquals(dto.email(), responseDTO.email());


        // We need to verify that the student is not saved to the database twice
        verify(studentMapper, times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDTO(savedStudent);
    }


    @Test
    public void should_return_all_students(){

        // Arrange -> What do I need before I test this?
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "john@example.com", 20));

        // Mock all available_calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDTO(any(Student.class))).thenReturn(new StudentResponseDTO("John", "Doe", "john@example.com"));

        // Act -> What am I testing
        List<StudentResponseDTO> responseDTOS = studentService.findAllStudent();

        // Assert -> Does it work as expected ?
        assertEquals(students.size(), responseDTOS.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id(){
        // Arrange -> What do I need before I test this?
        Long studentId = 1L;
        Student student = new Student("John", "Doe", "john@mail.com", 20);

        // Mock all available calls
        when(repository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDTO(any(Student.class))).thenReturn(new StudentResponseDTO("John", "Doe", "john@mail.com"));

        // Act -> What am I testing?
        StudentResponseDTO dto = studentService.findStudentById(studentId);

        // Assert -> Does it work as expected?
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        verify(repository, times(1)).findById(studentId);
    }


    @Test
    public void should_return_student_by_name(){

        // 1. Arrange -> What do I need before I test this?
        String studentName = "John";
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", "john@mail.com", 20));

        // Mock all available calls
        when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDTO(any(Student.class))).thenReturn(new StudentResponseDTO("John", "Doe", "john@example.com"));

        // 2. Act -> What am I testing?
        var responseDto = studentService.findStudentsByName(studentName);

        // 3. Assert -> Does it work as expected?
        assertEquals(students.size(), responseDto.size());
    }
}