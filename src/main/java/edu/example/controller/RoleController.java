package edu.example.controller;

import edu.example.dto.Role;
import edu.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping("/add-role")
    public void addRole(Role role){
        service.addRole(role);

    }
    @GetMapping("/get-Role")
    public List<Role> getRole(){
       return service.getRole();
    }
}
