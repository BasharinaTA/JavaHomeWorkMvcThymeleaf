package com.homework_mvc_thymeleaf.services.department;

import com.homework_mvc_thymeleaf.model.Department;
import com.homework_mvc_thymeleaf.services.DataService;

public interface DepartmentService extends DataService<Department> {
    void update(Integer id, String name, String note, Integer parentId);
}
