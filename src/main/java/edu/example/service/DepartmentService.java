package edu.example.service;

import edu.example.dto.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);

    List<Department> getAllDepartments();
}

