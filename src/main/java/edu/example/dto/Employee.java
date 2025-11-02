package edu.example.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Department> department ;
    private Role role;

}
