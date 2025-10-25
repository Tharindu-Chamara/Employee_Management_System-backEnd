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

    public EmployeeController(EmployeeService service){
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

    @GetMapping("/id/{id}")
    public Object findById(@PathVariable Long id){
       return service.findById(id);
    }
    @GetMapping("/name/{name}")
    public Object findByName(@PathVariable  String name){

        return service.findByName(name);
    }
    @PutMapping("/update_emp/{id}")
    public void updateEmployee(@PathVariable Long id ,@RequestBody Employee employee){
        service.updateEmployee(id,employee);
    }

}

