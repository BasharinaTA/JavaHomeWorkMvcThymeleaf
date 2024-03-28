package com.homework_mvc_thymeleaf.services.department;

import com.homework_mvc_thymeleaf.model.entities.Department;
import com.homework_mvc_thymeleaf.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getAllOrderById() {
        return departmentRepository.findAllByOrderById();
    }

    @Override
    public Department get(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void update(Department department, Integer parentId) {
        Optional<Department> departmentOption = departmentRepository.findById(department.getId());
        if (departmentOption.isPresent()) {
            Department departmentToUpdate = departmentOption.get();
            if (parentId != null) {
                departmentToUpdate.setParentDept(departmentRepository.findById(parentId).orElse(null));
            } else {
                departmentToUpdate.setParentDept(null);
            }
            departmentToUpdate.setName(department.getName());
            departmentToUpdate.setNote(department.getNote());
            departmentRepository.save(departmentToUpdate);
        }
    }

    @Override
    public void delete(Integer id) {
        List<Department> children = departmentRepository.findChildren(id);
        if (children.isEmpty()) {
            departmentRepository.deleteById(id);
        }
    }
}
