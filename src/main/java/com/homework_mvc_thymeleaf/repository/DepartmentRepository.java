package com.homework_mvc_thymeleaf.repository;

import com.homework_mvc_thymeleaf.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("FROM Department department  WHERE department.parentDept.id = :id")
    List<Department> findChildren(Integer id);
}
