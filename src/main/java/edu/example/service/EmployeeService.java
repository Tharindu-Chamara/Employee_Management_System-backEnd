package edu.example.service;

import edu.example.dto.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getEmployee();

    void deleteEmployee(Long id);
}
