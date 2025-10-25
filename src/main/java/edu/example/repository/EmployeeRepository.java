package edu.example.repository;

import edu.example.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
       Optional<EmployeeEntity> findByFirstName(String firstName);


}
