package com.homework_mvc_thymeleaf.services.employee;

import com.homework_mvc_thymeleaf.exceptions.RecordNotFoundException;
import com.homework_mvc_thymeleaf.model.entities.Employee;
import com.homework_mvc_thymeleaf.repository.EmployeeRepository;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAllByOrderById();
    }

    @Override
    public List<Employee> getAllOrderById() {
        return employeeRepository.findAllByOrderById();
    }

    @Override
    public Employee get(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        Employee employeeToUpdate = employeeRepository.findById(employee.getId()).orElseThrow(RecordNotFoundException::new);
        employeeToUpdate.setFio(employee.getFio());
        employeeToUpdate.setNote(employee.getNote());
        employeeToUpdate.setDepartment(employee.getDepartment());
        employeeToUpdate.setProfession(employee.getProfession());
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
