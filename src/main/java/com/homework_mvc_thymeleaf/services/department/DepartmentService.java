package com.homework_mvc_thymeleaf.services.department;

import com.homework_mvc_thymeleaf.model.entities.Department;
import com.homework_mvc_thymeleaf.services.DataService;

import java.util.List;

public interface DepartmentService extends DataService<Department> {
    List<Department> getAllOrderById();

    void update(Department department, Integer parentId);
}
