package org.theMungai.Student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    // This method will be executed ONLY ONCE BEFORE ALL our test methods
    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all method");
    }

    // This method will be executed ONLY ONCE AFTER our test methods
    @AfterAll
    static void afterAll(){
        System.out.println("Inside the after all method");
    }

    // This setUp method will be executed BEFORE EACH test methods that we have
    @BeforeEach
    void setUp() {
        System.out.println("Inside before each method");
    }

    // This tearDown method will be executed AFTER EACH test methods that we have
    @AfterEach
    void tearDown(){
        System.out.println("Inside after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first test method");
    }

    @Test
    public void testMethod2(){
        System.out.println("My second test method");
    }
}