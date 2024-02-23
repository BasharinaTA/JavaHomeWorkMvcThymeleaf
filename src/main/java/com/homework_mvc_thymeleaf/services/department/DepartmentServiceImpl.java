package com.homework_mvc_thymeleaf.services.department;

import com.homework_mvc_thymeleaf.model.Department;
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
    public Department get(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void update(Integer id, String name, String note, Integer parentId) {
        Optional<Department> departmentOption = departmentRepository.findById(id);
        if (departmentOption.isPresent()) {
            Department department = departmentOption.get();
            if (parentId != null) {
                department.setParentDept(departmentRepository.findById(parentId).orElse(null));
            } else {
                department.setParentDept(null);
            }
            department.setName(name);
            department.setNote(note);
           departmentRepository.save(department);
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
