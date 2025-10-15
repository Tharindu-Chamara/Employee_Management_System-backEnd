package edu.example.controller;


import edu.example.dto.Employee;
import edu.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void  addEmployee( @RequestBody Employee employee){
         service.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployee(){
       return service.getEmployee();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee( @PathVariable Long id){
            service.deleteEmployee(id);
            return "Deleted";
    }

}

