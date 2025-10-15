package edu.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.dto.Employee;
import edu.example.entity.EmployeeEntity;
import edu.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void addEmployee(Employee employee) {
        repository.save(mapper.convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getEmployee() {
        List<Employee> employeeList= new ArrayList<>();
        for(EmployeeEntity entity:repository.findAll()){
           employeeList.add(mapper.convertValue(entity,Employee.class));
        }
        return employeeList;
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
