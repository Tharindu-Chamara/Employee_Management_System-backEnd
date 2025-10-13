package edu.example.controller;


import edu.example.dto.Employee;
import edu.example.entity.EmployeeEntity;
import edu.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeService service;

    EmployeeController(EmployeeService service){
        this.service=service;
    }

    @PostMapping
    public void  addEmployee( @RequestBody Employee employee){
         service.addEmployee(employee);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployee(){
       return service.getEmployee();
    }

}

