package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.dto.Role;
import edu.example.entity.RoleEntity;
import edu.example.repository.RoleRepository;
import edu.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private  final RoleRepository repository;

    @Override
    public void addRole(Role role) {
        RoleEntity roleEntity = new ObjectMapper().convertValue(role, RoleEntity.class);
        repository.save(roleEntity);
        ;

    }

    @Override
    public List<Role> getRole() {
        List<Role> roleList = new ArrayList<>();
        List<RoleEntity> all = repository.findAll();
        all.forEach(roleEntity ->roleList.add(new ObjectMapper().convertValue(all,Role.class)));
        return roleList;
    }

    @Override
    public String deleteById(Long id) {
        repository.deleteById(id);
        return "Delete Success";
    }
}
