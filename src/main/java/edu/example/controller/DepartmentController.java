package edu.example.controller;

import edu.example.dto.Department;
import edu.example.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@CrossOrigin
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping("/add-department")
    public void addDepartment(@RequestBody  Department department){
          service.addDepartment(department);
    }

    @GetMapping("/get-departments")
    public List<Department> getAllDepartments(){
       return service.getAllDepartments();
    }


}
