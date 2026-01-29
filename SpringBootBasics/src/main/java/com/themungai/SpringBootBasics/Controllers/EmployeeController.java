package com.themungai.SpringBootBasics.Controllers;

import com.themungai.SpringBootBasics.Employee;
import com.themungai.SpringBootBasics.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }
}
