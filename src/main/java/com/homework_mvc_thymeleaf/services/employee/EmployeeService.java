package com.homework_mvc_thymeleaf.services.employee;

import com.homework_mvc_thymeleaf.model.entities.Employee;
import com.homework_mvc_thymeleaf.services.DataService;

import java.util.List;

public interface EmployeeService extends DataService<Employee> {
    List<Employee> getAllOrderById();

    Employee update(Employee employee);
}
