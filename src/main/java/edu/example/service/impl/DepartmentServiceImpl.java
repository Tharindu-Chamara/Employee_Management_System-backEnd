package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.dto.Department;
import edu.example.entity.DepartmentEntity;
import edu.example.repository.DepartmentRepository;
import edu.example.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final ObjectMapper mapper;

    @Override
    public void addDepartment(Department department) {
        repository.save(mapper.convertValue(department,DepartmentEntity.class));

    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        List<DepartmentEntity> all = repository.findAll();
        all.forEach(departmentEntity ->
                list.add(mapper.convertValue(all,Department.class)));
        return list;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        repository.deleteById(id);
        return "Deleted";
    }
}
