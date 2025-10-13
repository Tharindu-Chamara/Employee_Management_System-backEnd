package edu.example.service;

import edu.example.dto.Employee;
import edu.example.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<EmployeeEntity> getEmployee();
}
