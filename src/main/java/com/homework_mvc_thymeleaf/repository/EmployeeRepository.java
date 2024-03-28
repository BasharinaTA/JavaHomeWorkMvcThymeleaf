package com.homework_mvc_thymeleaf.repository;

import com.homework_mvc_thymeleaf.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderById();
}
