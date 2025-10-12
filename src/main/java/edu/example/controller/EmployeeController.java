package edu.example.controller;


import edu.example.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    List<Employee> employee1=new ArrayList();

    @PostMapping
    public void  addEmployee( @RequestBody Employee employee){
        employee1.add(employee);
    }

}
