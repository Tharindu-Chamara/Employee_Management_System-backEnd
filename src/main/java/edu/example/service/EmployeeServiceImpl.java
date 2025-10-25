package edu.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.dto.Employee;
import edu.example.entity.EmployeeEntity;
import edu.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Object findById(Long id) {
        if(id==null){
            return "Employee Id Cannot be null";
        }
        Optional<EmployeeEntity> byId = repository.findById(id);
        return byId.isPresent()? mapper.convertValue(byId.get(),Employee.class)
                : "Employee NOt Found in this id";
    }

    @Override
    public Object findByName(String name) {
        Optional<EmployeeEntity> byName = repository.findByFirstName(name);
        return byName.isPresent()? mapper.convertValue(byName.get(),Employee.class)
                : "Employee Not Found in this name";
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Optional<EmployeeEntity> byId = repository.findById(id);
        if(byId.isPresent()){
            EmployeeEntity entity = byId.get();

            entity.setFirstName(employee.getFirstName());
            entity.setLastName(employee.getLastName());
            entity.setEmail(employee.getEmail());
            entity.setDepartmentId(employee.getDepartmentId());
            entity.setRoleId(employee.getRoleId());

            repository.save(entity);
        }
    }
}
