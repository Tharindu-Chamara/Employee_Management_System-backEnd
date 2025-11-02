package edu.example.service;

import edu.example.dto.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role> getRole();

    String deleteById(Long id);

}
